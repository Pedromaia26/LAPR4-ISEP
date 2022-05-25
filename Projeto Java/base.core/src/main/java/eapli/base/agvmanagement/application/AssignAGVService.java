package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.eclipse.persistence.sessions.server.Server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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

            sOut.writeUTF("1");

            String response=sIn.readUTF();
            System.out.println(response);
            sock.close();
            return true;
        } catch (Exception e) {
            System.out.println("Server down");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
