package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVBuilder;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBuilder;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.List;

public class AGVController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TaskRepository taskRepository = PersistenceContext.repositories().tasks();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();


    public AGV addAGV(final String agvIdentifier, final String agvShortDescription, final double autonomy, final double maximumWeight, final String model, final double volume) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE);
        long taskid = 1;
        Task task = taskRepository.findTaskByID(taskid);
        final var newAGV = new AGVBuilder(agvIdentifier, agvShortDescription, autonomy, maximumWeight, model, task, volume);


        return agvRepository.save(newAGV.build());
    }
}
