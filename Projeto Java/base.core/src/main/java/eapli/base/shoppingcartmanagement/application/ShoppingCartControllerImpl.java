package eapli.base.shoppingcartmanagement.application;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.domain.Quantity;
import eapli.base.productmanagement.domain.Product;
import eapli.base.productmanagement.repositories.ProductRepository;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import javax.persistence.NoResultException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShoppingCartControllerImpl implements ShoppingCartController {
    private final ProductRepository productRepository = PersistenceContext.repositories().products();
    private final TransactionalContext txCtx = PersistenceContext.repositories().newTransactionalContext();
    private final ShoppingCartRepository shoppingCartRepository = PersistenceContext.repositories().shoppingCarts(txCtx);
    private final ShoppingCartLineRepository shoppingCartLineRepository = PersistenceContext.repositories().shoppingCartLines(txCtx);
    private final ClientUserRepository clientUserRepository = PersistenceContext.repositories().clientUsers();

    @Override
    public boolean addProductShoppingCart(final String productInfo){
        try{
            txCtx.beginTransaction();
            ShoppingCart sc = null;
            try {
                Product product = productRepository.findByReference(deconcatenateString(productInfo).get(0));
                Quantity q = new Quantity(Integer.parseInt(deconcatenateString(productInfo).get(1)));
                final ShoppingCartLine newShoppingCartLine = new ShoppingCartLine(product, q, product.Price());
                final ShoppingCartLine scl = shoppingCartLineRepository.save(newShoppingCartLine);

                final ShoppingCart shoppingCart = getShoppingCartUser(deconcatenateString(productInfo).get(2));
                shoppingCart.addShoppingCartLine(scl);

                sc = shoppingCartRepository.save(shoppingCart);
                txCtx.commit();
            }catch (Exception e){
                txCtx.rollback();
                throw new IllegalArgumentException();
            }
            return true;
        } catch (Exception e){
            txCtx.rollback();
            throw new IllegalArgumentException("Server down, cannot add products to shopping cart!\n");
        }
    }

    public ShoppingCart getShoppingCartUser(String cvat){
        ShoppingCart shoppingCart;
        try{
            shoppingCart = shoppingCartRepository.findByVat(cvat);
            return shoppingCart;
        } catch (NoResultException e){
            ClientUser user = clientUserRepository.findByVAT(cvat);
            shoppingCart = new ShoppingCart(user);
            System.out.println(shoppingCart);
        }
        return shoppingCart;
    }


    public List<String> deconcatenateString(String s){
        return Arrays.asList(s.split(","));
    }
}
