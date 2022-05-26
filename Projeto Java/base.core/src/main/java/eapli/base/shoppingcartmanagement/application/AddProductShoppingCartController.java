package eapli.base.shoppingcartmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.NoResultException;
import java.util.Optional;


public class AddProductShoppingCartController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final AddProductShoppingCartService svc = new AddProductShoppingCartService();

    public boolean addProductShoppingCart(final String productReference, final int quantity){
        svc.addProductShoppingCartService(concatenateString(productReference, String.valueOf(quantity), getUserSessionVat().vat()));

        return false;
    }

    public VAT getUserSessionVat(){
        return getUser().identity();
    }

    public ClientUser getUser(){
        Username username = authz.session().get().authenticatedUser().username();
        Optional<ClientUser> client = clientUserRepository.findByUsername(username);
        return client.get();
    }

    public String concatenateString(String s1, String s2, String s3){
        return s1 + "," + s2 + "," + s3;
    }
}
