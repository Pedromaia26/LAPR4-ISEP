package eapli.base.productmanagement.application;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBuilder;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.List;

public class VerifyFreeStorageAreaController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    public boolean verify(final long aisleID, final long sectionID, final long shelfID) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        Product product = productRepository.findProductWithLocation(aisleID, sectionID, shelfID);
        if (product == null)
            return false;
        else
            return true;
    }

}
