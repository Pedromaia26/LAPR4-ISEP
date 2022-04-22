package eapli.base.usermanagement.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.Calendars;

import java.util.Calendar;
import java.util.Set;

public class AddCostumerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    public SystemUser addUser(final String username, final String password, final String firstName,
                              final String lastName,
                              final String email, final Set<Role> roles, final Calendar createdOn) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

        return userSvc.registerNewUser(username, password, firstName, lastName, email, roles,
                createdOn);
    }

    public SystemUser addUser(final String username, final String password, final String firstName,
                              final String lastName,
                              final String email, final Set<Role> roles) {
        return addUser(username, password, firstName, lastName, email, roles, Calendars.now());
    }
}
