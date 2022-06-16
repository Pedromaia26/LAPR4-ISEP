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

public class UpdateStatusRechargeService {

    private InetAddress serverIP;
    private SSLSocket sock;
    private static final String TRUSTED_STORE_SERVER = "certificates/server.jks";
    private static final String TRUSTED_STORE_CLIENT = "certificates/client.jks";
    private static final String KEYSTORE_PASS = "Password1";
    private static final Logger LOGGER = LogManager.getLogger(UpdateStatusRechargeService.class);



    public boolean updateStatusRechargeService(String id) {

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
            if(!updateStatusRechargeAGV(sIn, sOut, id)){
                throw new IllegalArgumentException("Error requesting the data");
            }
            if(!endOfSession(sIn, sOut)){
                throw new IllegalArgumentException("Error ending the communication");
            }

            sock.close();
            return true;
        } catch (Exception e) {
            LOGGER.debug("Server down\n");
            return false;
        }
    }

    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_comm_test = new byte[]{1, 0, 0, 0};
            sOut.write(array_comm_test);
            LOGGER.debug(Arrays.toString(sIn.readNBytes(4)) + "\n");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateStatusRechargeAGV(DataInputStream sIn, DataOutputStream sOut, String id) {
        try {
            byte[] dataLength = CommunicationProtocol.dataLengthCalculator(id);
            byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1, CommunicationProtocol.UPDATE_AGV_STATUS_RECHARGE_CODE, dataLength[0], dataLength[1]};

            sOut.write(array);
            sOut.write(id.getBytes());

            byte[] array_response = sIn.readNBytes(4);

            int dataLength2 = array_response[2] + 256 * array_response[3];
            byte[] data = sIn.readNBytes(dataLength2);

            String parsedData = new String(data);
            LOGGER.debug(parsedData + "\n");
            return true;
        }catch(Exception e) {
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
