package eapli.base.shoppingcartmanagement.application;

import eapli.base.communicationprotocol.CommunicationProtocol;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class AddProductShoppingCartService {
    private InetAddress serverIP;
    private SSLSocket sock;
    private static final String TRUSTED_STORE = "certificates/server.jks";
    private static final String KEYSTORE_PASS = "Password1";


    public boolean addProductShoppingCartService(String product) {

            //Trust this cert provided by server
            System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
            System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

            // Use this certificate and private key for client certificate when requested by the server
            //System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
            //System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

            SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();


            try {
                try {
                    serverIP = InetAddress.getByName("localhost");
                } catch (UnknownHostException ex) {
                    System.out.println("Invalid server specified");
                    System.exit(1);
                }

                try {
                    sock = (SSLSocket) sf.createSocket(serverIP, 8898);
                } catch (IOException ex) {
                    System.out.println("Failed to establish TCP connection");
                    System.out.println("Application aborted");
                    // System.exit(1);
                }

                sock.startHandshake();

                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sIn = new DataInputStream(sock.getInputStream());


            communicationTest(sIn, sOut);
            choosedProduct(sOut,sIn, product);
            endOfSession(sIn, sOut);



            sock.close();
            return true;
        } catch (Exception e) {
            System.out.println("Server down");
            System.out.println(e.getMessage());
            return false;
        }
    }

    protected boolean choosedProduct(DataOutputStream sOut, DataInputStream sIn, String product){
        try {
            byte[] dataLength = CommunicationProtocol.dataLengthCalculator(product);
            byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1, CommunicationProtocol.ADD_PRODUCT_SHOPPING_CART_CODE, dataLength[0], dataLength[1]};

            sOut.write(array);
            sOut.write(product.getBytes());

            byte[] array_response = sIn.readNBytes(4);

            int dataLength2 = array_response[2] + 256 * array_response[3];
            byte[] data = sIn.readNBytes(dataLength2);

            String parsedData = new String(data);
            System.out.println(parsedData);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) throws IOException {
        byte[] array_comm_test = new byte[]{1, 0, 0, 0};
        sOut.write(array_comm_test);

        System.out.println(Arrays.toString(sIn.readNBytes(4)));



        return false;
    }
    public boolean endOfSession(DataInputStream sIn, DataOutputStream sOut) throws IOException {
        byte[] array_end_session = new byte[]{1, 1, 0, 0};
        sOut.write(array_end_session);
        System.out.println(Arrays.toString(sIn.readNBytes(4)));
        return false;
    }
}
