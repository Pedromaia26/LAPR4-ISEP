package eapli.base.infrastructure.bootstrapers;

import eapli.base.categorymanagement.application.DefineNewCategoryController;
import eapli.base.categorymanagement.application.ListCategoryController;
import eapli.base.categorymanagement.domain.Category;
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

public class CategoryBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final DefineNewCategoryController defineNewCategoryController = new DefineNewCategoryController();

    public CategoryBootstrapperBase() {
        super();
    }


    protected boolean addCategory(final String code, final String description) {
        try {
            defineNewCategoryController.addCategory(code, description);
            LOGGER.debug("»»» %s", code);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            System.out.println("Something went wrong.");
        }
        return true;
    }
}
