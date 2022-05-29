package eapli.base.agvmanagement.application;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class AssignAGVService {

    private InetAddress serverIP;
    private Socket sock;

    public boolean assignAGVService() {

        try {
            try {
                serverIP = InetAddress.getByName("localhost");
            } catch (UnknownHostException ex) {
                System.out.println("Invalid server specified");
                System.exit(1);
            }
            try {
                sock = new Socket(serverIP, 8899);
            } catch (IOException ex) {
                System.out.println("Failed to establish TCP connection");
                System.out.println(ex.getMessage());
                // System.exit(1);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
            DataInputStream sIn = new DataInputStream(sock.getInputStream());

            if(!communicationTest(sIn, sOut)){
                throw new IllegalArgumentException("Error testing the communication");
            }
            if(!assignAgvToOrders(sIn, sOut)){
                throw new IllegalArgumentException("Error requesting the data");
            }
            if(!endOfSession(sIn, sOut)){
                throw new IllegalArgumentException("Error ending the communication");
            }

            sock.close();
            return true;
        } catch (Exception e) {
            System.out.println("Server down");
            return false;
        }
    }

    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_comm_test = new byte[]{1, 0, 0, 0};
            sOut.write(array_comm_test);
            System.out.println(Arrays.toString(sIn.readNBytes(4)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean assignAgvToOrders(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array = new byte[]{1, 100, 0, 0};
            sOut.write(array);
            byte[] array_response = sIn.readNBytes(4);
            int dataLength = array_response[2] + 256 * array_response[3];
            byte[] data = sIn.readNBytes(dataLength);
            String parsedData = new String(data);
            System.out.println(parsedData);
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public boolean endOfSession(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_end_session = new byte[]{1, 1, 0, 0};
            sOut.write(array_end_session);
            System.out.println(Arrays.toString(sIn.readNBytes(4)));
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
