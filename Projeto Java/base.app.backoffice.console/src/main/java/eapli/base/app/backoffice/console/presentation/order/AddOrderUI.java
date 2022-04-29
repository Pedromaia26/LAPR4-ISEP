package eapli.base.app.backoffice.console.presentation.order;

import eapli.base.app.backoffice.console.presentation.authz.AddCostumerUI;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.product.ListProductUI;
import eapli.base.clientusermanagement.application.ListClientUsersController;
import eapli.base.ordermanagement.application.AddOrderController;
import eapli.base.ordermanagement.application.AddOrderLineController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.application.ListProductController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddOrderUI  extends AbstractUI {

    private final AddOrderController theOrderController = new AddOrderController();
    private final AddOrderLineController theOrderLineController = new AddOrderLineController();
    private final ListProductController theLController = new ListProductController();
    private final ListClientUsersController theUserController = new ListClientUsersController();
    private boolean invalidData, invalidProduct, invalidShipMethod, invalidPaymentMethod;
    ProductOrder productOrder;

    @Override
    protected boolean doShow() {

        do{
            final String clientVat = Console.readLine("Client VAT");
            try{
                productOrder = theOrderController.addOrder(clientVat);
            } catch (Exception e) {
                System.out.println("Invalid VAT. Client does not exist!");
                AddCostumerUI addCostumerUI = new AddCostumerUI();
                addCostumerUI.show();
            }

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
                theOrderLineController.addOrderLine(productCode, productOrder.identity(), quantity);
            }while (Console.readLine("Do you want to add more products? (Y/N)").equals("Y"));

            Set<String[]> deliveringPostalAddress = new HashSet<>();
            String[] strings1= new String[5];
            String strings= "default";
            strings1[0] = strings;
            deliveringPostalAddress.add(strings1);

            Set<String[]> billingPostalAddress = new HashSet<>();
            billingPostalAddress.add(strings1);
            List<String> lists;
            int index = 1;

            String op1 = Console.readLine("Do you want to use the client delivering postal address? (Y/N)");
            if (op1.equals("N")){
                String s = Console.readLine("Delivering Postal Address");
                strings1[0] = s;
                deliveringPostalAddress.add(strings1);
            }
            else if (op1.equals("Y")){
                Set<String> deliveringPostalAddresses = theUserController.deliveringAddressOfAClient(clientVat);
                lists = new ArrayList<>();
                deliveringPostalAddresses.iterator().forEachRemaining(lists::add);
                for (String address : lists){
                    System.out.println(index + " - " + address);
                    index++;
                }
                String ad = Console.readLine("Select one of the addresses");
                deliveringPostalAddress.add(lists.get(Integer.parseInt(ad)-1).split(","));
            }

            index = 1;

            op1 = Console.readLine("Do you want to use the client billing postal address? (Y/N)");
            if (op1.equals("N")){
                String s = Console.readLine("Billing Postal Address");
                strings1[0] = s;
                billingPostalAddress.add(strings1);
            }
            else if (op1.equals("Y")){
                Set<String> billingPostalAddresses = theUserController.billingAddressOfAClient(clientVat);
                lists = new ArrayList<>();
                billingPostalAddresses.iterator().forEachRemaining(lists::add);
                for (String address : lists){
                    System.out.println(index + " - " + address);
                    index++;
                }
                String ad = Console.readLine("Select one of the addresses");
                billingPostalAddress.add(lists.get(Integer.parseInt(ad)-1).split(","));
            }

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
                theOrderController.addOrder(clientVat, productOrder, deliveringPostalAddress, billingPostalAddress, shipmentMethod,  shipmentCost, paymentMethod);
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
