package agvdigitaltwin.tcpprotocol.server;

import eapli.base.agvmanagement.application.*;
import eapli.base.agvmanagement.domain.Battery;
import eapli.base.communicationprotocol.CommunicationProtocol;

public class UpdateStatusRechargeRequest extends AgvDigitalTwinProtocolRequest{
    private String agvID;
    private Long id;

    private AGVStatusController agvStatusController = new AGVStatusControllerImpl();
    private AGVMovement.Methods methods;


    protected UpdateStatusRechargeRequest(AGVManagerController controller, String inputRequest, AGVMovement.Methods methods) {
        super(controller, inputRequest);
        this.agvID = inputRequest;
        this.methods = methods;

    }

    @Override
    public String execute() {

        // semantic validation

        // execution
        agvStatusController.updateStatusRecharge(agvID);

        Runnable r = new Runnable() {
            public void run() {
                RechargingAGV rechargingAGV = new RechargingAGV();
                try {
                    rechargingAGV.main(agvID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        new Thread(r).start();
        // response
        return buildResponse();

    }

    @Override
    public byte[] outputProtocol() {
        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(buildResponse());
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.UPDATE_AGV_STATUS_RECHARGE_RESPONSE_CODE, dataLength[0], dataLength[1]};
        return array;
    }

    private String buildResponse() {
        return String.format("Agv %s status updated", agvID);
    }

}
