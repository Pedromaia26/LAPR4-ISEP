package eapli.base.infrastructure.bootstrapers;

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

public class ProductBootstrapperBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersBootstrapperBase.class);

    final SpecifyNewProductController specifyNewProductController = new SpecifyNewProductController();

    public ProductBootstrapperBase() {
        super();
    }


    protected boolean addProduct(final Category category, final List<String> setOfPhoto, final String shortDescription, final String extendedDescription,
                                 final String technicalDescription, final String brand, final String reference, final String productionCode,
                                 final String internalCode, final double price, final String barcode, final double height, final double length, final double width,
                                 final double weight, final long aisleID, final long sectionID, final long shelfID) {
        try {
            specifyNewProductController.addProduct(category, setOfPhoto, shortDescription, extendedDescription, technicalDescription, brand, reference,
                    productionCode, internalCode, price, barcode, height, length, width, weight, aisleID, sectionID, shelfID);
            LOGGER.debug("»»» %s", internalCode);
        } catch (final IntegrityViolationException | ConcurrencyException | IOException e) {
            // assuming it is just a primary key violation due to the tentative
            // of inserting a duplicated user. let's just lookup that user
            System.out.println("Something went wrong.");
        }
        return true;
    }
}
