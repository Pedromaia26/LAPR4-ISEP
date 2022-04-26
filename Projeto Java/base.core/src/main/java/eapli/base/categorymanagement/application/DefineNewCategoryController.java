package eapli.base.categorymanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryBuilder;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@UseCaseController
public class DefineNewCategoryController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final CategoryRepository categoryRepository = PersistenceContext.repositories().categories();

    public Category addCategory(final String code, final String description) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        final var newCategory = new CategoryBuilder(code, description);


        return categoryRepository.save(newCategory.build());
    }
}
