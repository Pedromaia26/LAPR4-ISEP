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

        // semantic validation

        // execution

            agvManagerController.addOrderWithAGV("1");
            // response
            return buildResponse();

    }

    private String buildResponse() {
        return "Assigned";
    }
}
