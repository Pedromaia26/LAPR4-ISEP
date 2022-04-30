package eapli.base.Warehouse.application;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.productmanagement.application.ListProductService;
import eapli.base.productmanagement.domain.Product;

public class AGVDockListController {
    private final AGVDockListService svc = new AGVDockListService();

    public Iterable<AGVDock> agvDocks() {
        return svc.agvDocks();
    }


}
