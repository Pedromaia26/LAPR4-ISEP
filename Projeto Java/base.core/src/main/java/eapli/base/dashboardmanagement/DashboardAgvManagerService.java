package eapli.base.dashboardmanagement;

import eapli.base.agvmanagement.application.UpdateStatusFreeService;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DashboardAgvManagerService {
    private InetAddress serverIP;
    private SSLSocket sock;
    private static final String TRUSTED_STORE_SERVER = "certificates/server.jks";
    private static final String TRUSTED_STORE_CLIENT = "certificates/httpserver.jks";
    private static final String KEYSTORE_PASS = "Password1";
    private static final Logger LOGGER = LogManager.getLogger(DashboardAgvManagerService.class);


    private String response;

    public String assignAGVService() {

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
                sock = (SSLSocket) sf.createSocket(serverIP, 8899);
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
            if(!sendRequest(sIn, sOut)){
                throw new IllegalArgumentException("Error requesting the data");
            }
            if(!endOfSession(sIn, sOut)){
                throw new IllegalArgumentException("Error ending the communication");
            }




            sock.close();
            return response;
        } catch (Exception e) {
            LOGGER.debug(e.getMessage() + "\n");
            LOGGER.debug("Server down\n");
            return "error in DashboardAgvManagerService";
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

    public boolean sendRequest(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array = new byte[]{1, 110, 0, 0};
            sOut.write(array);
            byte[] array_response = sIn.readNBytes(4);
            int first= array_response[2] & 0xFF;
            int second= array_response[3] & 0xFF;


            int dataLength = first + 256 * second;
            byte[] data = sIn.readNBytes(dataLength);
            response = new String(data);
            LOGGER.debug(response + "\n");
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            LOGGER.debug(e.getMessage() + "\n");
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
