package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.app.backoffice.console.presentation.authz.AddCostumerUI;
import eapli.base.app.backoffice.console.presentation.product.ListProductUI;
import eapli.base.categorymanagement.application.ListCategoryController;
import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.application.UpdateOrderStatusController;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UpdateOrderDispatchedUI extends AbstractUI {

    private final ListProductOrderController thePOController = new ListProductOrderController();
    private final UpdateOrderStatusController theUPOController = new UpdateOrderStatusController();
    boolean invalidProductOrder, invalidData;
    private String productOrderId;

    @Override
    protected boolean doShow() {

        do{
            ListOrderPreparedUI listOrderPreparedUI = new ListOrderPreparedUI();
            listOrderPreparedUI.show();

            do {
                try {
                    productOrderId = Console.readLine("Please select one of the product orders (Enter the id)");
                    thePOController.findByCode(productOrderId);
                    invalidProductOrder = false;
                } catch (Exception e) {
                    System.out.println("Invalid id. Product Order does not exist!");
                    invalidProductOrder = true;
                }
            }while (invalidProductOrder);

            try {
                theUPOController.UpdateOrderToDispatched(productOrderId);
                System.out.println("Product order updated with success!");
            } catch (Exception e) {
                System.out.println("Something went wrong, please try again!");
                invalidData = true;
            }
        }while(invalidData);


        return false;
    }

    @Override
    public String headline() {
        return "Update Order";
    }
}
