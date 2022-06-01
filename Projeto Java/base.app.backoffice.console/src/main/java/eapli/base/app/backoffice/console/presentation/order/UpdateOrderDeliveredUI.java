package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.application.UpdateOrderStatusController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class UpdateOrderDeliveredUI extends AbstractUI {

    private final ListProductOrderController thePOController = new ListProductOrderController();
    private final UpdateOrderStatusController theUPOController = new UpdateOrderStatusController();
    boolean invalidProductOrder, invalidData;
    private String productOrderId;

    @Override
    protected boolean doShow() {

        do{
            invalidData = false;
            ListOrderDispatchedUI listOrderDispatchedUI = new ListOrderDispatchedUI();
            listOrderDispatchedUI.show();

            if (theUPOController.verifyIfExistsOrdersDispatched()) {
                do {
                    try {
                        productOrderId = Console.readLine("Please select one of the product orders (Enter the id)");
                        thePOController.findDispacthedOrderById(productOrderId);
                        invalidProductOrder = false;
                    } catch (Exception e) {
                        System.out.println("Invalid id. Product Order does not exist or it is not prepared yet!");
                        invalidProductOrder = true;
                    }
                } while (invalidProductOrder);

                try {
                    theUPOController.updateOrderToDelivering(productOrderId);
                    System.out.println("Product order updated with success!");
                } catch (Exception e) {
                    System.out.println("Something went wrong, please try again!");
                    invalidData = true;
                }
            }
        }while(invalidData);


        return false;
    }

    @Override
    public String headline() {
        return "Update Order";
    }
}
