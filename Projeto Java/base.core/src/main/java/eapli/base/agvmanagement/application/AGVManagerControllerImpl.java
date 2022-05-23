package eapli.base.agvmanagement.application;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.ListProductOrderService;
import eapli.base.ordermanagement.domain.*;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.statusManagement.StatusListController;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.List;

public class AGVManagerControllerImpl implements AGVManagerController {

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders(txCtx);
    private final ListProductOrderService listProductOrderService = new ListProductOrderService();
    private TasksListService svcTask = new TasksListService();
    private AGVListService svcAGV = new AGVListService();
    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv(txCtx);
    private final StatusListController statusListController = new StatusListController();
    private AGV agv;

    @Override
    public boolean addOrderWithAGV() {

        try{
            Task task = svcTask.findTaskById(3L);
            for (AGV atAgv: svcAGV.agv()){
                txCtx.beginTransaction();
                if (atAgv.Task().hasIdentity(1L)){
                    atAgv.modifyTask(task);
                    agv = atAgv;
                    for (ProductOrder pO: listProductOrderService.orderList()){
                        if (pO.Status().hasIdentity(1L)){
                            configureAGVController.modifyAGVTask(agv, task, agvRepository);
                            pO.modifyAgv(agv);
                            Status status = statusListController.findStatusById(4L);
                            pO.modifyStatus(status);
                            orderRepository.save(pO);
                            txCtx.commit();
                            break;
                        }
                    }
                }
                txCtx.close();
            }
        }catch (Exception e){
            txCtx.rollback();
        }

        return true;

    }

}
