package eapli.base.shoppingcartmanagement.application;

import eapli.base.productmanagement.application.ListProductService;
import eapli.base.productmanagement.domain.Product;
import eapli.base.shoppingcartmanagement.domain.ShoppingCartLine;

public class ListShoppingCartController {
    private final ListShoppingCartService svc = new ListShoppingCartService();

    public Iterable<ShoppingCartLine> allLines() {
        return svc.allLines();
    }
}
