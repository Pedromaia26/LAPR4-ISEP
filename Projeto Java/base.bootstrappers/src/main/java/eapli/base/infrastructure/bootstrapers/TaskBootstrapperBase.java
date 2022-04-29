package eapli.base.infrastructure.bootstrapers;

import eapli.base.orderstatusmanagement.application.AddStatusController;
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

import java.util.Set;

public class TaskBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final AddTaskController addTaskController = new AddTaskController();

    public TaskBootstrapperBase() {
        super();
    }

    /**
     * @param description
     */
    protected boolean addTask(final String description) {
        try {
            addTaskController.addTask(description);
            LOGGER.debug("»»» %s", description);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            System.out.println("Something went wrong.");
        }
        return true;
    }
}
