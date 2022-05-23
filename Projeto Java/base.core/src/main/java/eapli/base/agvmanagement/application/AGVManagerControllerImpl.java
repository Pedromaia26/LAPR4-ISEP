package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.ListProductOrderService;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AGVManagerControllerImpl implements AGVManagerController {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders(txCtx);
    private final ListProductOrderService listProductOrderService = new ListProductOrderService();
    private TasksListService svcTask = new TasksListService();
    private AGVListService svcAGV = new AGVListService();
    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv(txCtx);
    private AGV agv;

    @Override
    public boolean addOrderWithAGV(String orderID) {

        txCtx.beginTransaction();

        try{
            Task task = svcTask.findTaskById(3L);
            System.out.println(task);
            for (AGV atAgv: svcAGV.agv()){
                if (atAgv.Task().hasIdentity(1L)){
                    atAgv.modifyTask(task);
                    agv = atAgv;
                    break;
                }
            }

            if (agv==null){
                throw new IllegalArgumentException("No AGV is free!");
            }

            ProductOrder productOrder = listProductOrderService.findByCode(orderID);

            configureAGVController.modifyAGVTask(agv, task, agvRepository);

            productOrder.modifyAgv(agv);

            orderRepository.save(productOrder);

            txCtx.commit();

        }catch (Exception e){
            txCtx.rollback();
        }

        return true;

    }

}
