package eapli.base.infrastructure.bootstrapers;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.ordermanagement.application.AddOrderController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.orderstatusmanagement.application.AddStatusController;
import eapli.base.productmanagement.application.SpecifyNewProductController;
import eapli.base.taskmanagement.application.AddTaskController;
import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.application.ListUsersController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ProductOrderBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final AddOrderController addOrderController = new AddOrderController();

    public ProductOrderBootstrapperBase() {
        super();
    }


    protected boolean addProductOrder(final String clientvat) {
        try {
            addOrderController.addOrder(clientvat);
            LOGGER.debug("»»» %s", clientvat);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            System.out.println("Something went wrong.");
        }
        return true;
    }
}
