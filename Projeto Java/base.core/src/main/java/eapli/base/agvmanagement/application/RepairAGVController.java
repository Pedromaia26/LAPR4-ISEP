package eapli.base.agvmanagement.application;

public class RepairAGVController {

    UpdateStatusMaintenanceService updateStatusMaintenanceService = new UpdateStatusMaintenanceService();

    public boolean repairAGV(String id){
        updateStatusMaintenanceService.updateStatusMaintenanceService(id);
        return false;
    }

}
