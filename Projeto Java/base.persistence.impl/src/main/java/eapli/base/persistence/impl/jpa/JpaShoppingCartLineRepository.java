package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartLineRepository;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaShoppingCartLineRepository extends JpaAutoTxRepository<ShoppingCartLine, Long, Long>
        implements ShoppingCartLineRepository {

    public JpaShoppingCartLineRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaShoppingCartLineRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "vat");
    }

    @Override
    public Iterable<ShoppingCartLine> findLinesByShoppingCart(Long id) {
        final TypedQuery<ShoppingCartLine> query = super.createQuery(
                "SELECT d FROM ShoppingCartLine d, ShoppingCart_ShoppingCartLines b WHERE d.id = b.shoppingcartline_id AND b.shoppingcart_id = " + id,
                ShoppingCartLine.class);

        return query.getResultList();
    }
}
