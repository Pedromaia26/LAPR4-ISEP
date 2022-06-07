package agvmanager.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.communicationprotocol.CommunicationProtocol;
import eapli.base.dashboardmanagement.DashBoardManagementController;
import eapli.base.dashboardmanagement.DashBoardManagementControllerImpl;

public class DashboardRequest extends AgvManagerProtocolRequest{
    private DashBoardManagementController dashBoardManagementController = new DashBoardManagementControllerImpl();


    protected DashboardRequest(AGVManagerController controller) {
        super(controller, null);

    }


    @Override
    public String execute() {

        String response;

        // execution
        try{
            dashBoardManagementController.openDashboard();
            response = buildResponse();
        }catch (Exception e){
            response = e.getMessage();

        }
        // response
        return response;

    }

    @Override
    public byte[] outputProtocol() {

        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(buildResponse());
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.DASHBOARD_TO_AGVMANAGER_RESPONSE_CODE, dataLength[0], dataLength[1]};
        return array;
    }

    private String buildResponse() {
        return String.format("Dashboard communication open successfully");
    }
}
