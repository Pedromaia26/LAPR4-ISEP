package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.app.backoffice.console.presentation.product.ListProductUI;
import eapli.base.ordermanagement.application.AddOrderController;
import eapli.base.ordermanagement.application.AddOrderLineController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.application.ListProductController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class AddOrderUI  extends AbstractUI {

    private final AddOrderController theOrderController = new AddOrderController();
    private final AddOrderLineController theOrderLineController = new AddOrderLineController();
    private final ListProductController theLController = new ListProductController();
    private boolean invalidData, invalidProduct, invalidShipMethod, invalidPaymentMethod;
    ProductOrder productOrder;

    @Override
    protected boolean doShow() {

        do{
            final String clientVat = Console.readLine("Client VAT");
            productOrder = theOrderController.addOrder(clientVat);
            if (Console.readLine("Do you want to see the products catalog? (Y/N)").equals("Y")) {
                ListProductUI listProductUI = new ListProductUI();
                listProductUI.show();
            }

            String productCode = null;
            do{
                do {
                    try {
                        productCode = Console.readLine("Product Internal Code");
                        theLController.findByCode(productCode);
                        invalidProduct = false;
                    } catch (Exception e) {
                        System.out.println("Invalid code. Product does not exist!");
                        invalidProduct = true;
                    }
                }while (invalidProduct);
                final int quantity = Integer.parseInt(Console.readLine("Quantity"));
                theOrderLineController.addOrderLine(productCode, productOrder.Id(), quantity);
            }while (Console.readLine("Do you want to add more products? (Y/N)").equals("Y"));

            final String deliveringPostalAddress = Console.readLine("Delivering Postal Address");
            final String billingPostalAddress = Console.readLine("Billing Postal Address");
            double shipmentCost = 0;
            String shipmentMethod;
            do {
                shipmentMethod = Console.readLine("Shipment method (Standard, Blue, Green)");
                if (shipmentMethod.equals("Standard")){
                    invalidShipMethod = false;
                    shipmentCost = 1;
                }
                else if (shipmentMethod.equals("Blue")){
                    invalidShipMethod = false;
                    shipmentCost = 2;
                }
                else if (shipmentMethod.equals("Green")){
                    invalidShipMethod = false;
                    shipmentCost = 3;
                }
            }while (invalidShipMethod);

            String paymentMethod;
            do {
                paymentMethod = Console.readLine("Payment method (Paypal, Apple Pay)");
                if (paymentMethod.equals("Paypal") || paymentMethod.equals("Apple Pay")) invalidPaymentMethod = false;
            }while (invalidPaymentMethod);

            invalidData = false;

            try {
                theOrderController.addOrder(clientVat, productOrder.Id(), deliveringPostalAddress, billingPostalAddress, shipmentMethod,  shipmentCost, paymentMethod);
            } catch (IllegalArgumentException e) {
                System.out.println("\n"+ e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")){
                    System.out.println();
                    invalidData = true;
                }
            }
        }while(invalidData);


        return false;
    }

    @Override
    public String headline() {
        return "Add order";
    }
}