package eapli.base.taskmanagement.application;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.Warehouse.repositories.AGVDockRepository;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class TasksListService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TaskRepository taskRepository = PersistenceContext.repositories().tasks();

    public Iterable<Task> allTasks() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.SALES_CLERK);
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.SALES_CLERK);
        return taskRepository.findTaskByID(id);
    }


}
