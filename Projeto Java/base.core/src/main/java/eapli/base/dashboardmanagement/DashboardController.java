package eapli.base.dashboardmanagement;

import eapli.base.Warehouse.application.AGVDockListController;
import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.domain.Aisle;
import eapli.base.Warehouse.domain.Warehouse;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.Warehouse.repositories.AisleRepository;
import eapli.base.Warehouse.repositories.WarehouseRepository;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

public class DashboardController {
    private final DashboardService svc = new DashboardService();

    public void openDashboard() throws IOException {
        svc.openDashboard();
    }
}
