package eapli.base.infrastructure.bootstrapers;

import eapli.base.categorymanagement.application.DefineNewCategoryController;
import eapli.base.surveymanagement.application.AddNewContextController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final AddNewContextController addNewContextController = new AddNewContextController();

    public ContextBootstrapperBase() {
        super();
    }


    protected boolean addContext(final String description) {
        try {
            addNewContextController.addContext(description);
            LOGGER.debug("»»» %s", description);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            System.out.println("Something went wrong.");
        }
        return true;
    }
}
