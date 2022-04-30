package eapli.base.agvmanagement.application;

import eapli.base.Warehouse.application.AGVDockListService;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.domain.AGV;

public class AGVListController {

    private final AGVListService svc = new AGVListService();

    public Iterable<AGV> agv() {
        return svc.agv();
    }
}
