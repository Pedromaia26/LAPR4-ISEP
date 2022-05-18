package eapli.base.app.backoffice.console.presentation.forceOrder;

import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.application.ConfigureAGVController;
import eapli.base.agvmanagement.domain.AGV;
import eapli.base.ordermanagement.application.ForceOrderController;
import eapli.base.ordermanagement.application.OrderListController;
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
    private OrderListController orderListController = new OrderListController();
    private AGVListController agvListController = new AGVListController();
    private boolean invalidData;
    private AGV agvSelected;
    private ProductOrder orderSelected;


    @Override
    protected boolean doShow() {

        do {
            try {


                int index=0;
                for (ProductOrder productOrder: orderListController.productOrders()) {
                    index++;
                    System.out.println(index+" - "+productOrder);
                }
                final int opt= Integer.parseInt(Console.readLine("Select the number of the chosen order"));

                List<ProductOrder> productOrders=(List<ProductOrder>)orderListController.productOrders();
                orderSelected=productOrders.get(opt-1);
                index=0;
                for (AGV agv : agvListController.agv()) {
                    index++;
                    System.out.println(index+ " - "+agv);
                }
                final int opt2= Integer.parseInt(Console.readLine("Select the number of the chosen agv"));

                List<AGV> agvs=(List<AGV>)agvListController.agv();
                agvSelected=agvs.get(opt2-1);
            }catch (Exception e){
                System.out.println(e.getMessage());
                invalidData=true;
            }



            try {


                this.theController.forceOrder(agvSelected,orderSelected);
            } catch (final IntegrityViolationException | ConcurrencyException e) {
                System.out.println("That code is already associated.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + e.getMessage());
                if (Console.readLine("Do you want to try again? (Y/N)").equals("Y")) {
                    System.out.println();
                    invalidData = true;
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
