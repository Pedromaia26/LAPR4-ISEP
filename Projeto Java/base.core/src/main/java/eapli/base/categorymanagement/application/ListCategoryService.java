package eapli.base.categorymanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListCategoryService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();
    private String categoryCode;

    public Iterable<Category> allCategories() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        return categoryRepository.findAll();
    }

    public Category categoryByCode(String categoryCode) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        return categoryRepository.findByCode(categoryCode);
    }
}
