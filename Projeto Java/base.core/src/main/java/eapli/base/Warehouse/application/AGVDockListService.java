package eapli.base.Warehouse.application;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class AGVDockListService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final AGVDockRepository agvDockRepository = PersistenceContext.repositories().agvDock();

    public Iterable<AGVDock> agvDocks() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        return agvDockRepository.findAll();
    }
}
