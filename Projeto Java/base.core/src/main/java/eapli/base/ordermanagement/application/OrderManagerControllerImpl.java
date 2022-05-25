package eapli.base.ordermanagement.application;

import eapli.base.agvmanagement.application.AGVListService;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.repositories.AGVRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.statusManagement.StatusListController;
import eapli.base.taskmanagement.application.TasksListService;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class OrderManagerControllerImpl implements OrderManagerController {


}
