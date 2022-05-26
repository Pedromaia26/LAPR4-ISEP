package agvmanager.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.communicationprotocol.CommunicationProtocol;

public class AssignTaskRequest extends AgvManagerProtocolRequest {


    private AGVManagerController agvManagerController = new AGVManagerControllerImpl();

    protected AssignTaskRequest(AGVManagerController controller) {
        super(controller, null);

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

    @Override
    public byte[] outputProtocol() {

        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(buildResponse());
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.ASSIGN_AGV_TO_ORDER_REPONSE_CODE, dataLength[0], dataLength[1]};
        return array;
    }

    private String buildResponse() {
        return "Available orders are now being prepared by free AGVs";
    }
}
