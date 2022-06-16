package eapli.base.agvmanagement.application;

import eapli.base.Warehouse.application.AGVDockListService;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.usermanagement.domain.BaseRoles;

import java.util.List;

public class AGVListController {

    private final AGVListService svc = new AGVListService();

    public Iterable<AGV> agv() {
        return svc.agv();
    }

    public Iterable<AGV> freeAgvs(){
        return svc.freeAgvs();
    }

    public Iterable<AGV> agvsServingOrders(){
        return svc.agvsServingOrder();
    }

    public Iterable<AGV> agvsInMaintenance(){
        return svc.agvsInMaintenance();
    }

    public boolean verifyIfAGVsInMaintenaceExist(){
        List<AGV> list = (List<AGV>) agvsInMaintenance();
        return list.size() > 0;
    }

    public boolean verifyIfFreeAgvsExist(){
        List<AGV> list = (List<AGV>) freeAgvs();
        return list.size() > 0;
    }

    public boolean verifyIfAGVsServingOrdersExist(){
        List<AGV> list = (List<AGV>) agvsServingOrders();
        return list.size() > 0;
    }

    public AGV findAgvById(String id){
        return svc.findAgvById(id);
    }
    public AGV findAgvInMaintenance(String id){
        return svc.findAgvInMaintenance(id);
    }


}
