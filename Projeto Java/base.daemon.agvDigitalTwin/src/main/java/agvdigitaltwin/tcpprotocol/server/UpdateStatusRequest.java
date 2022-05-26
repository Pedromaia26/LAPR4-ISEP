package agvdigitaltwin.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.agvmanagement.application.AGVStatusController;
import eapli.base.agvmanagement.application.AGVStatusControllerImpl;

public class UpdateStatusRequest  extends AgvDigitalTwinProtocolRequest {

    private String agvID;
    private Long id;

    private AGVStatusController agvStatusController = new AGVStatusControllerImpl();

    protected UpdateStatusRequest(AGVManagerController controller, String inputRequest) {
        super(controller, inputRequest);
        this.agvID = inputRequest;
    }


    @Override
    public String execute() {

        // semantic validation

        // execution
        agvStatusController.updateStatus(agvID);
        // response
        return buildResponse();

    }

    private String buildResponse() {
        return String.format("Agv %s status updated", agvID);
    }

}
