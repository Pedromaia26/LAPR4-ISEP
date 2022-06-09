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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;

public class DashBoardManagementControllerImpl implements DashBoardManagementController {
    private final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouse();
    private final AGVDockRepository agvDockRepository = PersistenceContext.repositories().agvDock();
    private final AisleRepository aisleRepository = PersistenceContext.repositories().aisle();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private StringBuilder string = new StringBuilder("/dimensions/");




    public StringBuilder openDashboard() {
        try{
           return sendWarehouseInformationToDashboard();


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new StringBuilder("error");
    }

    public StringBuilder sendWarehouseInformationToDashboard(){
        Warehouse warehouse = getWarehouse("1");
        sendLength(warehouse.Length());
        sendWidth(warehouse.Width());
        sendSquare(warehouse.Square());
        sendAgvDock();
        sendAisle();
        sendAGV();

        /*request.setRequestMethod("PUT");
        request.setURI(string.toString());
        try{
            request.send(sOut);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        return string;
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

}
