package eapli.base.shoppingcartmanagement.repositories;

import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.framework.domain.repositories.DomainRepository;

public interface ShoppingCartLineRepository  extends DomainRepository<Long, ShoppingCartLine> {

    Iterable<ShoppingCartLine> findLinesByShoppingCart(Long id);

}
