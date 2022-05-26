package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.application.UpdateStatusController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class UpdateAGVStatusUI extends AbstractUI {

    private final AGVListController agvListController = new AGVListController();
    private final UpdateStatusController updateStatusController = new UpdateStatusController();
    private String agvID;
    private boolean invalidData, invalidAGVId;

    @Override
    protected boolean doShow() {

        ListAGVsServingOrdersUI listAGVsServingOrdersUI = new ListAGVsServingOrdersUI();
        listAGVsServingOrdersUI.show();


        if(agvListController.verifyIfAGVsServingOrdersExist()){
            do{
                invalidData = false;
                do {
                    try {
                        agvID = Console.readLine("Enter the id of the AGV which has finished its task");
                        agvListController.findAgvById(agvID);
                        invalidAGVId = false;
                    } catch (Exception e) {
                        System.out.printf("Invalid ID. AGV %s does not exist!\n", agvID);
                        invalidAGVId = true;
                    }
                }while(invalidAGVId);

                try{
                    updateStatusController.updateStatusWhenAGVTaskIsDone(agvID);
                }catch (Exception e){
                    System.out.println("Something went wrong, please try again!");
                    invalidData = true;
                }
            }while(invalidData);

        }
        return false;
    }

    @Override
    public String headline() {
        return "Update AGV Status";
    }
}
