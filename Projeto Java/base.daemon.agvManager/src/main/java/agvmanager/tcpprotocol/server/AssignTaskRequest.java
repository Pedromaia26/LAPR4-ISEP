package agvmanager.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;

public class AssignTaskRequest extends AgvManagerProtocolRequest {

    private String orderId;
    private Long id;

    private AGVManagerController agvManagerController = new AGVManagerControllerImpl();

    protected AssignTaskRequest(AGVManagerController controller, String inputRequest) {
        super(controller, inputRequest);
        this.orderId = inputRequest;
    }


    @Override
    public String execute() {

        String response;
        // execution
        try{
            agvManagerController.addOrderWithAGV();
            response = buildResponse();
        }catch (Exception e){
            response = e.getMessage();

        }
        // response
        return response;

    }

    private String buildResponse() {
        return "Available orders are now being prepared by free AGVs";
    }
}
