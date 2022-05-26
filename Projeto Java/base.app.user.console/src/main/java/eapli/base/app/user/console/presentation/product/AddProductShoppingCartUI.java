package eapli.base.app.user.console.presentation.product;

import eapli.base.app.backoffice.console.presentation.category.ListCategoryUI;
import eapli.base.categorymanagement.application.ListCategoryController;
import eapli.base.categorymanagement.domain.Category;
import eapli.base.clientusermanagement.application.ListClientUsersController;
import eapli.base.ordermanagement.application.AddOrderController;
import eapli.base.ordermanagement.application.AddOrderLineController;
import eapli.base.ordermanagement.application.UpdateOrderStatusController;
import eapli.base.productmanagement.application.ListProductController;
import eapli.base.productmanagement.application.SpecifyNewProductController;
import eapli.base.productmanagement.domain.Product;
import eapli.base.shoppingcartmanagement.application.AddProductShoppingCartController;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddProductShoppingCartUI extends AbstractUI {
    private final AddProductShoppingCartController theSCController = new AddProductShoppingCartController();
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
        final int quantity = Integer.parseInt(Console.readLine("Quantity"));
        try {
            theSCController.addProductShoppingCart(productReference, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("Something went wrong!");
        }

        return false;
    }

    @Override
    public String headline() {
        return "Add product to shopping cart";
    }
}
