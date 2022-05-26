package eapli.base.productmanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListProductService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();

    public Iterable<Product> allProducts() {
        /*authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COSTUMER_USER);*/


        return productRepository.findAll();
    }

    public Product findByCode(String productCode) {
        /*authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COSTUMER_USER);*/

        return productRepository.findByCode(productCode);
    }

    public Product findByReference(String productReference) {
        /*authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.COSTUMER_USER);*/

        return productRepository.findByReference(productReference);
    }
}
