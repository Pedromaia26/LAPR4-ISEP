package eapli.base.statusManagement;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class StatusListService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StatusRepository statusRepository = PersistenceContext.repositories().status();

    public Iterable<Status> allStatus() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.SALES_CLERK);
        return statusRepository.findAll();
    }

    public Status findStatusById(Long id){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.SALES_CLERK);
        return statusRepository.findByStatusId(id);
    }
}
