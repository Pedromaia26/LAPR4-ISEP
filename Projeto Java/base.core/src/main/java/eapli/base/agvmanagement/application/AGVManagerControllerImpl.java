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
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AGVManagerControllerImpl implements AGVManagerController {

    private static final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders(txCtx);
    private final ListProductOrderService listProductOrderService = new ListProductOrderService();
    private TasksListService svcTask = new TasksListService();
    private AGVListService svcAGV = new AGVListService();
    private final ConfigureAGVController configureAGVController = new ConfigureAGVController();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private final StatusListController statusListController = new StatusListController();
    private final UpdateStatusService updateStatusService = new UpdateStatusService();
    private final UpdateStatusFreeService updateStatusFreeService = new UpdateStatusFreeService();
    private final UpdateStatusRechargeService updateStatusRechargeService = new UpdateStatusRechargeService();
    private AGV agv;


    @Override
    public boolean addOrderWithAGV(boolean flag) {
        int random = 0;
        try{
            Task task = svcTask.findTaskById(3L);
            Task taskMaintenance = svcTask.findTaskById(4L);
            for (AGV atAgv: svcAGV.agv()){
                txCtx.beginTransaction();
                if (atAgv.Task().hasIdentity(1L)){
                    if (!flag){
                        random = (int) (Math.random()*4+1);
                    }
                    if (random < 3){
                        atAgv.modifyTask(task);
                        agv = atAgv;
                        for (ProductOrder pO: listProductOrderService.orderList()){
                            if (pO.Status().hasIdentity(1L)){
                                pO.modifyAgv(agv);
                                Status status = statusListController.findStatusById(4L);
                                pO.modifyStatus(status);
                                orderRepository.save(pO);
                                if(!updateStatusService.updateStatusService(pO.Agv().identity().AgvIdentifier())) {
                                    txCtx.rollback();
                                    throw new IllegalArgumentException("Server down, cannot assign AGVs to available orders!\n");
                                }else {
                                    txCtx.commit();
                                }
                                break;
                            }
                        }
                    }else {
                        try {
                            atAgv.modifyTask(taskMaintenance);
                            agv = atAgv;
                            agvRepository.save(agv);
                            txCtx.commit();
                        }catch (Exception e){
                            txCtx.rollback();
                        }

                    }
                }
                txCtx.close();
            }
        }catch (Exception e){
            txCtx.rollback();
            throw new IllegalArgumentException("Server down, cannot assign AGVs to available orders!\n");
        }

        return true;

    }

    @Override
    public boolean freeAgv(String id){

        txCtx.beginTransaction();

        ProductOrder productOrder = orderRepository.findOrderByAGVId(id);
        Status status = statusListController.findStatusById(5L);
        productOrder.modifyStatus(status);
        productOrder.modifyAgv(null);
        orderRepository.save(productOrder);

        if(!updateStatusFreeService.updateStatusFreeService(id)) {
            txCtx.rollback();
        }else{
            txCtx.commit();
        }

        return false;
    }

    @Override
    public boolean rechargingAGV(String id) {
        txCtx.beginTransaction();

        ProductOrder productOrder = orderRepository.findOrderByAGVId(id);
        Status status = statusListController.findStatusById(1L);
        productOrder.modifyStatus(status);
        productOrder.modifyAgv(null);
        orderRepository.save(productOrder);

        if(!updateStatusRechargeService.updateStatusRechargeService(id)) {
            txCtx.rollback();
        }else{
            txCtx.commit();
        }

        return false;
    }

    @Override
    public boolean rechargingAGVFinishedOrder(String id) {
        txCtx.beginTransaction();

        ProductOrder productOrder = orderRepository.findOrderByAGVId(id);
        Status status = statusListController.findStatusById(5L);
        productOrder.modifyStatus(status);
        productOrder.modifyAgv(null);
        orderRepository.save(productOrder);

        if(!updateStatusRechargeService.updateStatusRechargeService(id)) {
            txCtx.rollback();
        }else{
            txCtx.commit();
        }

        return false;
    }

    @Override
    public boolean AGVinMaintenance(String id) {
        Task task = svcTask.findTaskById(1L);
        AGV agv = agvRepository.findById(id);
        agv.modifyTask(task);
        agvRepository.save(agv);
        addOrderWithAGV(true);
        return false;
    }

}
