package eapli.base.app.user.console.presentation.order;

import eapli.base.app.backoffice.console.presentation.authz.AddCostumerUI;
import eapli.base.app.backoffice.console.presentation.product.ListProductUI;
import eapli.base.app.user.console.presentation.product.ViewShoppingCartUI;
import eapli.base.clientusermanagement.application.ListClientUsersController;
import eapli.base.ordermanagement.application.AddOrderController;
import eapli.base.ordermanagement.application.AddOrderLineController;
import eapli.base.ordermanagement.application.UpdateOrderStatusController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.productmanagement.application.ListProductController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.apache.commons.lang3.ObjectUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateOrderUI  extends AbstractUI {

    private final AddOrderController theOrderController = new AddOrderController();
    private final AddOrderLineController theOrderLineController = new AddOrderLineController();
    private final ListProductController theLController = new ListProductController();
    private final ListClientUsersController theUserController = new ListClientUsersController();
    private boolean invalidData, invalidProduct, invalidShipMethod = true, invalidPaymentMethod = true;
    UpdateOrderStatusController updateOrderStatusController = new UpdateOrderStatusController();
    private static InetAddress serverIP;
    private static Socket sock;


    @Override
    protected boolean doShow() {
        if (theOrderController.verifyOrder()){
            do{
                Set<String[]> deliveringPostalAddress = new HashSet<>();
                String[] strings1= new String[5];
                String strings= "default";
                strings1[0] = strings;

                Set<String[]> billingPostalAddress = new HashSet<>();
                List<String> lists;
                int index = 1;

                String op1 = Console.readLine("Do you want to use one of your delivering postal addresses? (Y/N)");
                if (op1.equals("N")){
                    String s = Console.readLine("Delivering Postal Address (Street name, Door number, Postal code, City, Country)");
                    deliveringPostalAddress.add(s.split(","));
                }
                else if (op1.equals("Y")){
                    Set<String> deliveringPostalAddresses = theUserController.deliveringAddressOfAClient();
                    lists = new ArrayList<>();
                    deliveringPostalAddresses.iterator().forEachRemaining(lists::add);
                    if (lists.size() > 0){
                        System.out.println("--- List of client delivering postal addresses ---");
                        for (String address : lists){
                            System.out.println(index + " - " + address);
                            index++;
                        }
                        String ad = "default";
                        do{
                            if (!ad.equals("default")){
                                System.out.println("Invalid chosen address. Choose again!");
                            }
                            ad = Console.readLine("Select one of the addresses");
                        } while (Integer.parseInt(ad) >= index || Integer.parseInt(ad) <= 0);
                        deliveringPostalAddress.add(lists.get(Integer.parseInt(ad)-1).split(","));
                    }
                    else {
                        System.out.println("There are no delivering postal addresses associated to the client!");
                        String s = Console.readLine("Delivering Postal Address (Street name, Door number, Postal code, City, Country)");
                        deliveringPostalAddress.add(s.split(","));
                    }
                }

                index = 1;

                op1 = Console.readLine("Do you want to use one of your billing postal addresses? (Y/N)");
                if (op1.equals("N")){
                    String s = Console.readLine("Billing Postal Address (Street name, Door number, Postal code, City, Country)");
                    billingPostalAddress.add(s.split(","));
                }
                else if (op1.equals("Y")){
                    Set<String> billingPostalAddresses = theUserController.billingAddressOfAClient();
                    lists = new ArrayList<>();
                    billingPostalAddresses.iterator().forEachRemaining(lists::add);
                    if (lists.size() > 0){
                        System.out.println("--- List of client billing postal addresses ---");
                        for (String address : lists){
                            System.out.println(index + " - " + address);
                            index++;
                        }
                        String ad = "default";
                        do{
                            if (!ad.equals("default")){
                                System.out.println("Invalid chosen address. Choose again!");
                            }
                            ad = Console.readLine("Select one of the addresses");
                        } while (Integer.parseInt(ad) >= index || Integer.parseInt(ad) <= 0);
                        billingPostalAddress.add(lists.get(Integer.parseInt(ad)-1).split(","));
                    }
                    else{
                        System.out.println("There are no billing postal addresses associated to the client!");
                        String s = Console.readLine("Billing Postal Address (Street name, Door number, Postal code, City, Country)");
                        billingPostalAddress.add(s.split(","));
                    }
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
                    theOrderController.addOrder(deliveringPostalAddress, billingPostalAddress, shipmentMethod, shipmentCost, paymentMethod);
                } catch (IllegalArgumentException e) {
                    System.out.println("\n"+ e.getMessage());
                    if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")){
                        System.out.println();
                        invalidData = true;
                    }
                } catch(NullPointerException e){
                    System.out.println("\n"+ e.getMessage());
                }
            }while(invalidData);
        }
        else{
            System.out.println("Please add a product to your shopping cart to do the checkout!");
        }


        return false;
    }

    @Override
    public String headline() {
        return "Creating order";
    }
}

