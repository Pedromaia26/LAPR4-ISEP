package eapli.base.agvmanagement.application;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVBuilder;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.AddOrderController;
import eapli.base.ordermanagement.application.ListProductOrderService;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
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

public class ConfigureAGVController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final TaskRepository taskRepository = PersistenceContext.repositories().tasks();
    private final AGVRepository agvRepository = PersistenceContext.repositories().agv();
    private final OrderRepository orderRepository = PersistenceContext.repositories().orders();;
    private final ListProductOrderService listProductOrderService = new ListProductOrderService();
    private ProductOrder productOrder;



    public AGV addAGV(final String agvIdentifier, final String agvShortDescription, final double autonomy, final double maximumWeight, final String model, final double volume, final AGVDock agvDock) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.WAREHOUSE_EMPLOYEE, BaseRoles.POWER_USER, BaseRoles.ADMIN);
        long taskid = 1;
        Task task = taskRepository.findTaskByID(taskid);
        final var newAGV = new AGVBuilder(agvIdentifier, agvShortDescription, autonomy, maximumWeight, model, task, volume, agvDock);


        return agvRepository.save(newAGV.build());
    }

    public AGV modifyAGVTask(AGV agv, Task taskId){

        agv.modifyTask(taskId);
        return agvRepository.save(agv);
    }

    public AGV modifyAGVTask(AGV agv, Task taskId, AGVRepository agvRepository){

        agv.modifyTask(taskId);
        return agvRepository.save(agv);

    }

    public ProductOrder assignAGVToAGivenOrder (AGV agv){

        for (ProductOrder order: listProductOrderService.orderList()){
            if (order.Agv() == null && order.Status().identity()==1L){
                order.modifyAgv(agv);
                productOrder = order;
                break;
            }
        }

        if (productOrder == null){
            return null;
        }

        return orderRepository.save(productOrder);
    }

}
