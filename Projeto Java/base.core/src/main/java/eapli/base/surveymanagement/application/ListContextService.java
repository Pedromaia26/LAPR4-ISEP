package eapli.base.surveymanagement.application;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.surveymanagement.domain.Context;
import eapli.base.surveymanagement.repositories.ContextRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.ApplicationService;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListContextService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ContextRepository contextRepository = PersistenceContext.repositories().contexts();

    public Iterable<Context> allContexts() {
        return contextRepository.findAll();
    }

    public Context contextByCode(Long id) {
        return contextRepository.findContextById(id);
    }
}
