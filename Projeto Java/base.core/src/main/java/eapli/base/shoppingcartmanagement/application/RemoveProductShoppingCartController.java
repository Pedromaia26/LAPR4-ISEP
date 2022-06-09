package eapli.base.shoppingcartmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.shoppingcartmanagement.domain.Line;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;


public class RemoveProductShoppingCartController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ShoppingCartLineRepository repo2 = PersistenceContext.repositories().shoppingCartLines(txCtx);
    private final ShoppingCartRepository repo = PersistenceContext.repositories().shoppingCarts(txCtx);

    public boolean removeProductShoppingCart(final String productReference){
        ShoppingCart Cart = repo.findByVat(getUserSessionVat().vat());
        for (Line line: Cart.shoppingCartLines()){
            if (line.shoppingCartLine().Product().Reference().toString().equals(productReference)){
                txCtx.beginTransaction();
                Cart.removeShoppingCartLine(line);
                repo.save(Cart);
                repo2.delete(line.shoppingCartLine());
                txCtx.commit();
            }
        }

        return false;
    }

    public boolean removeAllProductShoppingCart(){
        txCtx.beginTransaction();
        ShoppingCart Cart = repo.findByVat(getUserSessionVat().vat());
        for (Line line: Cart.shoppingCartLines()){
            Cart.removeShoppingCartLine(line);
            repo.save(Cart);
            repo2.delete(line.shoppingCartLine());
        }
        txCtx.commit();
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
}
