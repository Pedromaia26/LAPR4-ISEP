package eapli.base.ordermanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public class CheckOrdersController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final ViewClientOrdersService svc = new ViewClientOrdersService();

    public String getClientOrders(){
        return svc.viewClientOrdersService(getUserSessionVat().vat());
    }

    public VAT getUserSessionVat(){
        return getUser().identity();
    }

    public ClientUser getUser(){
        Username username = authz.session().get().authenticatedUser().username();
        Optional<ClientUser> client = clientUserRepository.findByUsername(username);
        return client.get();
    }
}
