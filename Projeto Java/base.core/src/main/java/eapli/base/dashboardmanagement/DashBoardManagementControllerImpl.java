package eapli.base.dashboardmanagement;

import java.io.IOException;

public class DashBoardManagementControllerImpl implements DashBoardManagementController {
    private final DashboardService svc = new DashboardService();

    public void openDashboard() {
        try{
            svc.openDashboard();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
