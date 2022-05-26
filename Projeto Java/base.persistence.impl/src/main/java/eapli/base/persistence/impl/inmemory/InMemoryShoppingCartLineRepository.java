package eapli.base.persistence.impl.inmemory;

import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

public class InMemoryShoppingCartLineRepository extends InMemoryDomainRepository<ShoppingCartLine, Long>
        implements ShoppingCartLineRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Iterable<ShoppingCartLine> findLinesByShoppingCart(Long id){ return null; }

}
