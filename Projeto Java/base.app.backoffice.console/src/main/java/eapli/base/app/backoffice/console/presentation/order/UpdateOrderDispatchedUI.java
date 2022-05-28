package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.application.UpdateOrderStatusController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class UpdateOrderDispatchedUI extends AbstractUI {

    private final ListProductOrderController thePOController = new ListProductOrderController();
    private final UpdateOrderStatusController theUPOController = new UpdateOrderStatusController();
    boolean invalidProductOrder, invalidData;
    private String productOrderId;

    @Override
    protected boolean doShow() {

        do{
            invalidData = false;
            ListOrderPreparedUI listOrderPreparedUI = new ListOrderPreparedUI();
            listOrderPreparedUI.show();

            if (theUPOController.verifyIfExistsOrdersPrepared()) {
                do {
                    try {
                        productOrderId = Console.readLine("Please select one of the product orders (Enter the id)");
                        thePOController.findByCode(productOrderId);
                        invalidProductOrder = false;
                    } catch (Exception e) {
                        System.out.println("Invalid id. Product Order does not exist!");
                        invalidProductOrder = true;
                    }
                } while (invalidProductOrder);

                try {
                    theUPOController.updateOrderToDispatched(productOrderId);
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
