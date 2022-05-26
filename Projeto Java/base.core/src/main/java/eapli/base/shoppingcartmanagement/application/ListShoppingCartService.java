package eapli.base.shoppingcartmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.shoppingcartmanagement.domain.Line;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ListShoppingCartService {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ShoppingCartRepository shoppingCartRepository = PersistenceContext.repositories().shoppingCarts(txCtx);
    private final ShoppingCartLineRepository shoppingCartLineRepository = PersistenceContext.repositories().shoppingCartLines(txCtx);

    public List<ShoppingCartLine> allLines() {

        List<ShoppingCartLine> list = new ArrayList<>();

        try {
            ShoppingCart sc = shoppingCartRepository.findByVat(getUserSessionVat().vat());
            Set<Line> set = sc.shoppingCartLines();

            for (Line line : set){
                list.add(line.shoppingCartLine());
            }
        } catch (NoResultException ignored){}

        return list;
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
