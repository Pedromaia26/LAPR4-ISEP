package eapli.base.usermanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.ClientUserBuilder;
import eapli.base.clientusermanagement.domain.events.NewUserRegisteredFromSignupEvent;
import eapli.base.clientusermanagement.domain.events.SignupAcceptedEvent;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.domain.events.DomainEvent;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.time.util.Calendars;

import java.util.Calendar;
import java.util.Set;

public class AddCostumerController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();
    private final TransactionalContext txCtx = PersistenceContext.repositories()
            .newTransactionalContext();
    private final ClientUserRepository clientUserRepository = PersistenceContext
            .repositories().clientUsers(txCtx);
    private final UserRepository userRepository = PersistenceContext.repositories().users();


    public ClientUser addUser(final String username, final String password, final String firstName,
                              final String lastName,
                              final String email, final Set<Role> roles, final Calendar createdOn, final String vat, final String phoneNumber,
                              final String gender, final String birthDay, final String delAddress, final String billAddress) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.SALES_CLERK);

            final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
            userBuilder.withUsername(username)
                    .withPassword(password)
                    .withName(firstName,lastName)
                    .withEmail(email)
                    .withRoles(BaseRoles.COSTUMER_USER);
            final SystemUser newUser = userRepository.save(userBuilder.build());


        final ClientUserBuilder clientUserBuilder = new ClientUserBuilder();
        clientUserBuilder.withVAT(vat).withPhoneNumber(phoneNumber).withGender(gender).withBirthDay(birthDay).withBillAddress(billAddress).withDelAddress(delAddress)
                .withSystemUser(newUser);

        return this.clientUserRepository.save(clientUserBuilder.build());
    }

    public ClientUser addUser(final String username, final String password, final String firstName,
                              final String lastName,
                              final String email, final Set<Role> roles, final String vat, final String phoneNumber,
                              final String gender, final String birthDay, final String delAddress, final String billAddress) {
        return addUser(username, password, firstName, lastName, email, roles, Calendars.now(),vat, phoneNumber, gender,  birthDay, delAddress, billAddress);
    }
}
