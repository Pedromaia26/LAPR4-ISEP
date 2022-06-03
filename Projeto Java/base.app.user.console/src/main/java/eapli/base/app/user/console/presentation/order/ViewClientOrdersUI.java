package eapli.base.app.user.console.presentation.order;

import eapli.base.ordermanagement.application.CheckOrdersController;
import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.application.ViewClientOrdersControllerImpl;
import eapli.base.ordermanagement.domain.OrderLine;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.statusManagement.StatusListController;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ViewClientOrdersUI extends AbstractUI
{
    private final CheckOrdersController theController = new CheckOrdersController();
    private final StatusListController sController = new StatusListController();

    @Override
    protected boolean doShow() {
        String data = theController.getClientOrders();
        String[] order = data.split("#");
        if (order.length <= 1){
            System.out.println("No orders.");
        }
        else {
            for (String s : order) {
                String[] orderData = s.split(",");
                System.out.println("======== Order " + orderData[0] + " ========");
                System.out.println("Created at: " + orderData[1]);
                System.out.println("Payment method: " + orderData[2]);
                System.out.println("Shipment method: " + orderData[3]);
                System.out.println("Total Cost (with taxes): " + orderData[4] + "€");

                if (Integer.parseInt(orderData[5]) >= 3 && Integer.parseInt(orderData[5]) <= 5)
                    System.out.println("Current Status: Being prepared");
                else if (Integer.parseInt(orderData[5]) >= 6 && Integer.parseInt(orderData[5]) <= 8)
                    System.out.println("Current Status: Dispatched");
                else
                    System.out.println("Current Status: " + sController.findStatusById(Long.parseLong(orderData[5])).Description().toString());

                System.out.println("------- List of Products ------");
                String[] products = s.split("_");
                for (int j = 1; j < products.length; j++) {
                    String[] productData = products[j].split(",");
                    System.out.println("Reference: " + productData[0]);
                    System.out.println("Description: " + productData[1]);
                    System.out.println("Brand: " + productData[2]);
                    System.out.println("Price: " + productData[3] + "€");
                    System.out.println("Quantity: " + productData[4]);
                    System.out.println("----------------------------");
                }
            }
        }

        return false;
    }

    @Override
    public String headline() {
        return "My orders";
    }
}
