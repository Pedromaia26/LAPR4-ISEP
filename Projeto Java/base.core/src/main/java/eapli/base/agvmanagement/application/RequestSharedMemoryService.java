package eapli.base.agvmanagement.application;

import eapli.base.communicationprotocol.CommunicationProtocol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class RequestSharedMemoryService {

    private InetAddress serverIP;
    private SSLSocket sock;
    private static final String TRUSTED_STORE_SERVER = "certificates/server.jks";
    private static final String TRUSTED_STORE_CLIENT = "certificates/httpserver.jks";
    private static final String KEYSTORE_PASS = "Password1";
    private String response;
    private static final Logger LOGGER = LogManager.getLogger(RequestSharedMemoryService.class);



    public String requestSharedMemoryService() {
        //Trust this cert provided by server
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE_SERVER);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE_CLIENT);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();


        try {
            try {
                serverIP = InetAddress.getByName("localhost");
            } catch (UnknownHostException ex) {
                LOGGER.debug("Invalid server specified\n");
                System.exit(1);
            }

            try {
                sock = (SSLSocket) sf.createSocket(serverIP, 8897);
            } catch (IOException ex) {
                LOGGER.debug("Failed to establish TCP connection\n");
                LOGGER.debug("Application aborted\n");
                // System.exit(1);
            }

            sock.startHandshake();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sIn = new DataInputStream(sock.getInputStream());


            if(!communicationTest(sIn, sOut)){
                throw new IllegalArgumentException("Error testing the communication");
            }
            if(!sharedMemory(sOut,sIn)){
                throw new IllegalArgumentException("Error requesting the data");
            }
            if(!endOfSession(sIn, sOut)){
                throw new IllegalArgumentException("Error ending the communication");
            }



            sock.close();
            LOGGER.debug("RESPONSE: " + response + "\n");
            return response;
        } catch (Exception e) {
            LOGGER.debug("Server down\n");
            return response;
        }
    }

    protected boolean sharedMemory(DataOutputStream sOut, DataInputStream sIn){
        try {
            byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1, CommunicationProtocol.SHARED_MEMORY, 0, 0};

            sOut.write(array);

            byte[] array_response = sIn.readNBytes(4);
            int first= array_response[2] & 0xFF;
            int second= array_response[3] & 0xFF;

            int dataLength2 = first + 256 * second;
            byte[] data = sIn.readNBytes(dataLength2);

            response = new String(data);
            LOGGER.debug(response + "\n");
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_comm_test = new byte[]{1, 0, 0, 0};
            sOut.write(array_comm_test);

            LOGGER.debug(Arrays.toString(sIn.readNBytes(4)) + "\n");
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public boolean endOfSession(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_end_session = new byte[]{1, 1, 0, 0};
            sOut.write(array_end_session);
            LOGGER.debug(Arrays.toString(sIn.readNBytes(4)) + "\n");
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
