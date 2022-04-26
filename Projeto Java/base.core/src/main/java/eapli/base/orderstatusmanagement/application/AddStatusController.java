package eapli.base.orderstatusmanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.orderstatusmanagement.domain.Status;
import eapli.base.orderstatusmanagement.domain.StatusBuilder;
import eapli.base.orderstatusmanagement.repositories.StatusRepository;
import eapli.base.productmanagement.domain.ProductBuilder;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.Calendars;

import java.util.Calendar;
import java.util.Set;

@UseCaseController
public class AddStatusController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final StatusRepository statusRepository = PersistenceContext.repositories().status();

    public Status addStatus(final String description) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        final StatusBuilder newStatus = new StatusBuilder(description);


        return statusRepository.save(newStatus.build());
    }
}
