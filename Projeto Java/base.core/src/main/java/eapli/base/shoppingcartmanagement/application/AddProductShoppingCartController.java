package eapli.base.shoppingcartmanagement.application;

import eapli.base.Warehouse.domain.Shelf;
import eapli.base.Warehouse.repositories.ShelfRepository;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.OrderLineBuilder;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.domain.Quantity;
import eapli.base.ordermanagement.repositories.OrderLineRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.domain.ProductBuilder;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.shoppingcartmanagement.domain.Line;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AddProductShoppingCartController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ShoppingCartRepository shoppingCartRepository = PersistenceContext.repositories().shoppingCarts(txCtx);
    private final ShoppingCartLineRepository shoppingCartLineRepository = PersistenceContext.repositories().shoppingCartLines(txCtx);

    public ShoppingCart addProductShoppingCart(final String productReference, final int quantity){
        txCtx.beginTransaction();
        ShoppingCart sc = null;
        try {
            Product product = productRepository.findByReference(productReference);
            Quantity q = new Quantity(quantity);
            final ShoppingCartLine newShoppingCartLine = new ShoppingCartLine(product, q, product.Price());
            final ShoppingCartLine scl = shoppingCartLineRepository.save(newShoppingCartLine);


            final ShoppingCart shoppingCart = getShoppingCartUser();
            shoppingCart.addShoppingCartLine(scl);

            sc = shoppingCartRepository.save(shoppingCart);
            txCtx.commit();
        }catch (Exception e){
            txCtx.rollback();
            throw new IllegalArgumentException();
        }
        return sc;
    }

    public ShoppingCart getShoppingCartUser(){
        VAT cvat = getUserSessionVat();
        ShoppingCart shoppingCart;
        try{
            shoppingCart = shoppingCartRepository.findByVat(cvat.vat());
            return shoppingCart;
        } catch (NoResultException e){
            shoppingCart = new ShoppingCart(getUser());
        }
        return shoppingCart;
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
