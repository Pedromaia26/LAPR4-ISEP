package eapli.base.ordermanagement.application;

import eapli.base.communicationprotocol.CommunicationProtocol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class ViewClientOrdersService {
    private InetAddress serverIP;
    private SSLSocket sock;
    private static final String TRUSTED_STORE_SERVER = "certificates/server.jks";
    private static final String TRUSTED_STORE_CLIENT = "certificates/client.jks";
    private static final String KEYSTORE_PASS = "Password1";
    private static final Logger LOGGER = LogManager.getLogger(ViewClientOrdersService.class);


    public String viewClientOrdersService(String clientVat) {

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
                sock = (SSLSocket) sf.createSocket(serverIP, 8898);
            } catch (IOException ex) {
                LOGGER.debug("Failed to establish TCP connection\n");
                LOGGER.debug(ex.getMessage() + "\n");
                // System.exit(1);
            }

            sock.startHandshake();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sIn = new DataInputStream(sock.getInputStream());


            communicationTest(sIn, sOut);
            String responseData = viewOrders(sOut,sIn, clientVat);
            endOfSession(sIn, sOut);



            sock.close();
            return responseData;
        } catch (Exception e) {
            LOGGER.debug("Server down\n");
            LOGGER.debug(e.getMessage() + "\n");
            return null;
        }
    }

    protected String viewOrders(DataOutputStream sOut, DataInputStream sIn, String clientVat){
        try {
            byte[] dataLength = CommunicationProtocol.dataLengthCalculator(clientVat);
            byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1, CommunicationProtocol.VIEW_CLIENT_ORDERS, dataLength[0], dataLength[1]};

            sOut.write(array);
            sOut.write(clientVat.getBytes());

            byte[] array_response = sIn.readNBytes(4);
            int first= array_response[2] & 0xFF;
            int second= array_response[3] & 0xFF;


            int dataLength2 = first + 256 * second;
            byte[] data = sIn.readNBytes(dataLength2);

            String parsedData = new String(data);
            return parsedData;
        }catch(Exception e) {
            return null;
        }

    }
    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) throws IOException {
        byte[] array_comm_test = new byte[]{1, 0, 0, 0};
        sOut.write(array_comm_test);

        LOGGER.debug(Arrays.toString(sIn.readNBytes(4)) + "\n");



        return false;
    }
    public boolean endOfSession(DataInputStream sIn, DataOutputStream sOut) throws IOException {
        byte[] array_end_session = new byte[]{1, 1, 0, 0};
        sOut.write(array_end_session);
        LOGGER.debug(Arrays.toString(sIn.readNBytes(4)) + "\n");
        return false;
    }
}
