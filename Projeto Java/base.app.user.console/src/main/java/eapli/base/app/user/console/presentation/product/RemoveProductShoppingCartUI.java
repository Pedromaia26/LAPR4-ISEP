package eapli.base.app.user.console.presentation.product;

import eapli.base.productmanagement.application.ListProductController;
import eapli.base.shoppingcartmanagement.application.AddProductShoppingCartController;
import eapli.base.shoppingcartmanagement.application.RemoveProductShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartControllerImpl;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RemoveProductShoppingCartUI extends AbstractUI {
    private final RemoveProductShoppingCartController theSCController = new RemoveProductShoppingCartController();
    private final ListProductController theLController = new ListProductController();
    private boolean invalidProduct;


    @Override
    protected boolean doShow() {
        String productReference = null;
        do {
            try {
                productReference = Console.readLine("Product Reference");
                theLController.findByReference(productReference);
                invalidProduct = false;
            } catch (Exception e) {
                System.out.println("Invalid reference. Product does not exist!");
                invalidProduct = true;
            }
        }while (invalidProduct);
        try {
            theSCController.removeProductShoppingCart(productReference);
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong!");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Remove a product from the shopping cart";
    }
}
