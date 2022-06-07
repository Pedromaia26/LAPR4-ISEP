package eapli.base.dashboardmanagement;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.Aisle;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.Warehouse.repositories.AisleRepository;
import eapli.base.Warehouse.repositories.WarehouseRepository;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;

public class DashboardService {
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final AGVDockRepository agvDockRepository = PersistenceContext.repositories().agvDock();
    private final AisleRepository aisleRepository = PersistenceContext.repositories().aisle();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    static private SSLSocket sock;
    static private InetAddress serverIP;
    static private int serverPort;
    static private DataOutputStream sOut;
    static private DataInputStream sIn;
    private StringBuilder string = new StringBuilder("/dimensions/");
    private static final String TRUSTED_STORE = "certificates/httpserver.jks";
    private static final String KEYSTORE_PASS = "Password1";



    public void sendWarehouseInformationToDashboard(){
        System.out.println("enter");
        HTTPmessage request = new HTTPmessage();
        Warehouse warehouse = getWarehouse("1");
        sendLength(warehouse.Length());
        sendWidth(warehouse.Width());
        sendSquare(warehouse.Square());
        sendAgvDock();
        sendAisle();
        sendAGV();
        request.setRequestMethod("PUT");
        request.setURI(string.toString());
        try{
            request.send(sOut);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Warehouse getWarehouse(String id){
        return warehouseRepository.findById(id);
    }

    public void sendLength(Long length){
        string.append(length);
        string.append(",");
    }

    public void sendWidth(Long width){
        string.append(width);
        string.append(",");
    }

    public void sendSquare(Long square){
        string.append(square);
        string.append(",");
    }

    public void sendAgvDock(){
        for (AGVDock agvDock: agvDockRepository.findAll()){
            string.append(";");
            string.append(agvDock.AgvDockBeginLSquare().BeginLSquare());
            string.append(",");
            string.append(agvDock.AgvDockBeginWSquare().BeginWSquare());
            string.append(",");
            string.append((agvDock.identity().Id()));
            string.append(",");
        }
    }

    public void sendAisle(){
        for (Aisle aisle: aisleRepository.findAll()){
            string.append("/");
            string.append(aisle.AisleBeginLSquare().BeginLSquare());
            string.append(",");
            string.append(aisle.AisleEndLSquare().EndLSquare());
            string.append(",");
            string.append(aisle.AisleBeginWSquare().BeginWSquare());
            string.append(",");
            string.append(aisle.AisleEndWSquare().EndWSquare());
            string.append(",");
            string.append(aisle.AisleDepthLSquare().DepthLSquare());
            string.append(",");
            string.append(aisle.AisleDepthWSquare().DepthWSquare());
            string.append(",");
        }
    }

    public void sendAGV(){
        for (AGV agv: agvRepository.findAll()){
            string.append("?");
            string.append(agv.AgvDock().identity().Id());
            string.append(",");
        }
    }

    public void openDashboard() throws IOException {

        //Trust this cert provided by server
        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASS);

        // Use this certificate and private key for client certificate when requested by the server
        System.setProperty("javax.net.ssl.keyStore", TRUSTED_STORE);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();



        try { serverIP = InetAddress.getByName("127.0.0.1"); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid SERVER-ADDRESS.");
            System.exit(1);
        }

        try { serverPort = 80; }
        catch(NumberFormatException ex) {
            System.out.println("Invalid SERVER-PORT.");
            System.exit(1);
        }

        try {sock = (SSLSocket) sf.createSocket(serverIP, serverPort);
            //sock=new Socket(serverIP, serverPort);
        }
        catch(IOException ex) {
            System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
            System.out.println("Application aborted.");
            System.exit(1);
        }

        sock.startHandshake();

        sOut = new DataOutputStream(sock.getOutputStream());
        sIn = new DataInputStream(sock.getInputStream());
        /*if(!communicationTest(sIn, sOut)){
            throw new IllegalArgumentException("Error testing the communication");
        }*/

        sendWarehouseInformationToDashboard();


       /* if(!endOfSession(sIn, sOut)){
            throw new IllegalArgumentException("Error ending the communication");
        }*/


        //Achamos que é por termos um thread aberta conectada a este socket
        //sock.close();

    }

    public boolean communicationTest(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_comm_test = new byte[]{1, 0, 0, 0};
            System.out.println("Entrou 1");
            sOut.write(array_comm_test);
            System.out.println(Arrays.toString(sIn.readNBytes(4)));
            System.out.println("Entrou 2");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean endOfSession(DataInputStream sIn, DataOutputStream sOut) {
        try {
            byte[] array_end_session = new byte[]{1, 1, 0, 0};
            sOut.write(array_end_session);
            System.out.println("recds"+Arrays.toString(sIn.readNBytes(4)));
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
