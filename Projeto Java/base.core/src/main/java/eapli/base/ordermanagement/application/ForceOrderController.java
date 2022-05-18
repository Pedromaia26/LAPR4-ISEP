package eapli.base.ordermanagement.application;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVBuilder;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.statusManagement.StatusListController;
import eapli.base.taskmanagement.application.TasksListController;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.taskmanagement.repositories.TaskRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class ForceOrderController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TaskRepository taskRepository = PersistenceContext.repositories().tasks();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private final OrderRepository orderRepository= PersistenceContext.repositories().orders();
    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();
    private final TasksListController tasksListController = new TasksListController();

    private final TransactionalContext txCtx = PersistenceContext.repositories()
            .newTransactionalContext();
    private final StatusListController statusListController= new StatusListController();
    private ProductOrder productOrder;
    private AGV agv;



    public ProductOrder forceOrder(AGV agv, ProductOrder productOrder){
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN, BaseRoles.SALES_CLERK);
        txCtx.beginTransaction();
        try {
            Task task = tasksListController.findTaskById(3L);
            configureAGVController.modifyAGVTask(agv, task);

            agv= agvRepository.save(agv);

            //Provavelmente vai chamar a US do maia e nela o estado do agv volta ao mesmo e a order avanca para finalizada

            Status status = statusListController.findStatusById(4L);
            productOrder.modifyStatus(status);
            this.productOrder= orderRepository.save(productOrder);
            txCtx.commit();
        }catch (Exception e){
            txCtx.rollback();
        }

        return this.productOrder;
    }
}
