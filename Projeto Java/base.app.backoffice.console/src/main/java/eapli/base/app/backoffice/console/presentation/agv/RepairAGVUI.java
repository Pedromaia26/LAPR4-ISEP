package eapli.base.app.backoffice.console.presentation.agv;

import eapli.base.agvmanagement.application.AGVListController;
import eapli.base.agvmanagement.application.RepairAGVController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

public class RepairAGVUI extends AbstractUI {


    private final AGVListController agvListController = new AGVListController();
    private final RepairAGVController repairAGVController = new RepairAGVController();
    private String agvID;
    private boolean invalidData, invalidAGVId;


    @Override
    protected boolean doShow() {

        ListAGVUI listAGVUI = new ListAGVUI();
        listAGVUI.show();


        if(agvListController.verifyIfAGVsInMaintenaceExist()){
            do{
                invalidData = false;
                do {
                    try {
                        agvID = Console.readLine("Enter the id of the AGV you want to repair!");
                        agvListController.findAgvInMaintenance(agvID);
                        invalidAGVId = false;
                    } catch (Exception e) {
                        System.out.printf("Invalid ID. AGV %s does not exist/it is not in maintenance!\n", agvID);
                        invalidAGVId = true;
                    }
                }while(invalidAGVId);

                try{
                    repairAGVController.repairAGV(agvID);
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
        return "Repair AGV";
    }
}
