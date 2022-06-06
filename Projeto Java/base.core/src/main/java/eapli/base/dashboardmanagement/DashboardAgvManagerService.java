package eapli.base.dashboardmanagement;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DashboardAgvManagerService {
    private InetAddress serverIP;
    private SSLSocket sock;
    private static final String TRUSTED_STORE = "certificates/server.jks";
    private static final String KEYSTORE_PASS = "Password1";

    public boolean assignAGVService() {

        //Trust this cert provided by server
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();


        try {
            try {
                serverIP = InetAddress.getByName("127.0.0.1");
            } catch (UnknownHostException ex) {
                System.out.println("Invalid server specified");
                System.exit(1);
            }

            try {
                sock = (SSLSocket) sf.createSocket(serverIP, 8899);
            } catch (IOException ex) {
                System.out.println("Failed to establish TCP connection");
                System.out.println("Application aborted");
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
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Server down");
            return false;
        }
    }

    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_comm_test = new byte[]{1, 0, 0, 0};
            sOut.write(array_comm_test);
            System.out.println("Commdams"+Arrays.toString(sIn.readNBytes(4)));
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
            int dataLength = array_response[2] + 256 * array_response[3];
            byte[] data = sIn.readNBytes(dataLength);
            String parsedData = new String(data);
            System.out.println("respdams: "+parsedData);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public boolean endOfSession(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_end_session = new byte[]{1, 1, 0, 0};
            sOut.write(array_end_session);
            System.out.println("recdams"+Arrays.toString(sIn.readNBytes(4)));
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
