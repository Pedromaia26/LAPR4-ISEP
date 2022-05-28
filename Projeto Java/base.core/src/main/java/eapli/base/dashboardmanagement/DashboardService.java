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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

public class DashboardService {
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final AGVDockRepository agvDockRepository = PersistenceContext.repositories().agvDock();
    private final AisleRepository aisleRepository = PersistenceContext.repositories().aisle();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    static private Socket sock;
    static private InetAddress serverIP;
    static private int serverPort;
    static private DataOutputStream sOut;
    static private DataInputStream sIn;
    private StringBuilder string = new StringBuilder("/dimensions/");

    HTTPmessage request = new HTTPmessage();

    public void sendWarehouseInformationToDashboard(){
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
        try { serverIP = InetAddress.getByName("localhost"); }
        catch(UnknownHostException ex) {
            System.out.println("Invalid SERVER-ADDRESS.");
            System.exit(1);
        }

        try { serverPort = 80; }
        catch(NumberFormatException ex) {
            System.out.println("Invalid SERVER-PORT.");
            System.exit(1);
        }

        try { sock = new Socket(serverIP, serverPort); }
        catch(IOException ex) {
            System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
            System.out.println("Application aborted.");
            System.exit(1);
        }

        sOut = new DataOutputStream(sock.getOutputStream());
        sIn = new DataInputStream(sock.getInputStream());

        sendWarehouseInformationToDashboard();
        java.awt.Desktop.getDesktop().browse(URI.create("http://localhost:80/"));
    }
}
