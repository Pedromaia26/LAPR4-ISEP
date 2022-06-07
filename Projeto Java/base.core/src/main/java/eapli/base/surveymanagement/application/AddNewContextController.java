package eapli.base.surveymanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryBuilder;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.ExtendedDescription;
import eapli.base.productmanagement.domain.ShortDescription;
import eapli.base.surveymanagement.domain.Context;
import eapli.base.surveymanagement.repositories.ContextRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

public class AddNewContextController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ContextRepository contextRepository = PersistenceContext.repositories().contexts();

    public Context addContext(final String description) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        final var newContext = new Context(new ExtendedDescription(description));


        return contextRepository.save(newContext);
    }
}
