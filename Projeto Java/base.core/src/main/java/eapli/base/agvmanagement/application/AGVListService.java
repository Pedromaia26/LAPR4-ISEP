package eapli.base.agvmanagement.application;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AGVListService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();

    public Iterable<AGV> agv() {

        return agvRepository.findAll();
    }

    public Iterable<AGV> freeAgvs() {

        return agvRepository.findFreeAGV();
    }

    public AGV findAgvById(String id) {
        return agvRepository.findByOrderId(id);
    }


    public Iterable<AGV> agvsServingOrder() {
        return agvRepository.findAGVServingOrder();
    }

}


