package agvdigitaltwin.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVStatusController;
import eapli.base.agvmanagement.application.AGVStatusControllerImpl;
import eapli.base.communicationprotocol.CommunicationProtocol;

public class UpdateStatusFreeRequest extends AgvDigitalTwinProtocolRequest {

    private String agvID;
    private Long id;

    private AGVStatusController agvStatusController = new AGVStatusControllerImpl();

    protected UpdateStatusFreeRequest(AGVManagerController controller, String inputRequest) {
        super(controller, inputRequest);
        this.agvID = inputRequest;
    }


    @Override
    public String execute() {

        // semantic validation

        // execution
        agvStatusController.updateStatusFree(agvID);
        // response
        return buildResponse();

    }

    @Override
    public byte[] outputProtocol() {
        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(buildResponse());
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.UPDATE_AGV_STATUS_FREE_RESPONSE_CODE, dataLength[0], dataLength[1]};
        return array;
    }

    private String buildResponse() {
        return String.format("Agv %s status updated", agvID);
    }

}
