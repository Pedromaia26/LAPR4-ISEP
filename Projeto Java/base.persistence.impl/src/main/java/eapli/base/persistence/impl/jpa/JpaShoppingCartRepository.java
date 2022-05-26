package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryCode;
import eapli.base.categorymanagement.repositories.CategoryRepository;
import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.VAT;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.domain.Product;
import eapli.base.shoppingcartmanagement.domain.ShoppingCart;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;
import eapli.base.shoppingcartmanagement.repositories.ShoppingCartRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaShoppingCartRepository extends JpaAutoTxRepository<ShoppingCart, Long, Long>
        implements ShoppingCartRepository {

    public JpaShoppingCartRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaShoppingCartRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "vat");
    }

    @Override
    public ShoppingCart findByVat(String Vat) {
        final TypedQuery<ShoppingCart> query = super.createQuery(
                "SELECT d FROM ShoppingCart d WHERE clientuser_vat = '" + Vat + "'",
                ShoppingCart.class);

        return query.getSingleResult();
    }
}
