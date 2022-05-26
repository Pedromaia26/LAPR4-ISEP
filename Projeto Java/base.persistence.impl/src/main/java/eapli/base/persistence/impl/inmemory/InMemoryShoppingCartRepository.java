package eapli.base.persistence.impl.inmemory;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryShoppingCartRepository extends InMemoryDomainRepository<ShoppingCart, Long>
        implements ShoppingCartRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public ShoppingCart findByVat(String vat) {
        return null;
    }

}
