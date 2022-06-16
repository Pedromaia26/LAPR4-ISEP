package agvmanager.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.communicationprotocol.CommunicationProtocol;

public class RechargeAGVFinishedOrderRequest extends AgvManagerProtocolRequest{
    private AGVManagerController agvManagerController = new AGVManagerControllerImpl();
    private String agvID;

    protected RechargeAGVFinishedOrderRequest(AGVManagerController controller, String inputData) {
        super(controller, inputData);
        agvID=inputData;
    }


    @Override
    public String execute() {

        String response;

        // execution
        try{
            agvManagerController.rechargingAGVFinishedOrder(agvID);
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
                CommunicationProtocol.AGV_RECHARGE_FINISHED_ORDER_RESPONSE_CODE, dataLength[0], dataLength[1]};
        return array;
    }

    private String buildResponse() {
        return String.format("AGV %s is recharging.", agvID);
    }
}
