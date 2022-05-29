package eapli.base.app.backoffice.console.presentation.forceOrder;

import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.app.backoffice.console.presentation.agv.ListAGVUI;
import eapli.base.ordermanagement.application.ForceOrderController;
import eapli.base.ordermanagement.application.ListProductOrderController;
import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.taskmanagement.application.TasksListController;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ForceOrderUI extends AbstractUI {
    private ForceOrderController theController = new ForceOrderController();
    private ListProductOrderController orderListController = new ListProductOrderController();
    private AGVListController agvListController = new AGVListController();
    private boolean invalidData = false, freeAGV = false, invalidOrderID;
    private AGV agvSelected;
    private ProductOrder orderSelected;
    private String productOrderId;


    @Override
    protected boolean doShow() {

        do {
            invalidData = false;
            ListOrderToForceUI listOrderToForceUI = new ListOrderToForceUI();
            listOrderToForceUI.show();

            if (orderListController.verifyIfExistsOrdersPrepared()) {
                try {
                    do {
                        invalidOrderID = false;
                        try {
                            productOrderId = Console.readLine("Please select one of the product orders (Enter the id)");
                            orderSelected = orderListController.findRegisteredOrderById(productOrderId);
                        } catch (Exception e) {
                            invalidOrderID = true;
                            throw new IllegalArgumentException("Invalid order");
                        }
                    }while (invalidOrderID);

                    ListAGVUI listAGVUI = new ListAGVUI();
                    listAGVUI.show();

                    if (agvListController.verifyIfFreeAgvsExist()){
                        freeAGV = true;
                        try {
                            final String opt2 = Console.readLine("Select the number of the chosen agv(Enter AGV id)");
                            agvSelected = agvListController.findAgvById(opt2);
                        } catch (Exception e) {
                            invalidData = true;
                            throw new IllegalArgumentException("Invalid AGV");
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    invalidData = true;
                }

                if(freeAGV) {
                    try {
                        this.theController.forceOrder(agvSelected, orderSelected);
                    } catch (final IntegrityViolationException | ConcurrencyException e) {
                        System.out.println("That code is already associated.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage());
                        if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                            System.out.println();
                            invalidData = true;
                        }
                    }
                }

            }
        }while(invalidData);

        return false;

    }

    @Override
    public String headline() {
        return "Configure AGV";
    }
}
