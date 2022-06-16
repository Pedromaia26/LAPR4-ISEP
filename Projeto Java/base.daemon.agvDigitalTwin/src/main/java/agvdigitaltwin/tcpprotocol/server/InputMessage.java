package agvdigitaltwin.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.agvmanagement.application.AGVMovement;
import eapli.base.communicationprotocol.CommunicationProtocol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class InputMessage {

    private static final Logger LOGGER = LogManager.getLogger(InputMessage.class);

    private static final Object lock = new Object();

    private static AGVManagerController controller = new AGVManagerControllerImpl();

    private InputMessage() {
        // avoid instantiation
    }

    /*private static AGVManagerController getController() {
        synchronized (lock) {
            if (InputMessage.controller != null) {
                return InputMessage.controller;
            }
        }
        return new AGVManagerControllerImpl();
    }*/

    public static AgvDigitalTwinProtocolRequest parseMessage(byte[] arr, DataInputStream in, DataOutputStream dataOutputStream, AGVMovement.Methods methods) throws IOException {

        AgvDigitalTwinProtocolRequest agvDigitalTwinProtocolRequest = null;

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.COMM_TEST_CODE) {
            dataOutputStream.write(CommunicationProtocol.ACK_MESSAGE_V1);
            dataOutputStream.flush();
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.DISCONN_CODE) {
            dataOutputStream.write(CommunicationProtocol.ACK_MESSAGE_V1);
            dataOutputStream.flush();
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.UPDATE_AGV_STATUS_CODE) {

            agvDigitalTwinProtocolRequest = inputUpdateStatus(arr, in, methods);
        }
        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.UPDATE_AGV_STATUS_FREE_CODE) {

            agvDigitalTwinProtocolRequest = inputUpdateStatusFree(arr, in, methods);
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.SHARED_MEMORY) {

            agvDigitalTwinProtocolRequest = inputSharedMemory(arr, in, methods);
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.UPDATE_AGV_STATUS_RECHARGE_CODE) {
            agvDigitalTwinProtocolRequest = inputUpdateStatusRecharge(arr, in, methods);
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.UPDATE_AGV_STATUS_RECHARGE_FINISHED_ORDER_CODE) {
            agvDigitalTwinProtocolRequest = inputUpdateStatusRechargeFinishedOrder(arr, in, methods);
        }

            return agvDigitalTwinProtocolRequest;
    }


    private static AgvDigitalTwinProtocolRequest inputUpdateStatus(final byte[] array, DataInputStream in, final AGVMovement.Methods methods) {
        AgvDigitalTwinProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
            LOGGER.debug(e.getMessage() + "\n");
        }

        request = new UpdateStatusRequest(controller, parsedData, methods);

        return request;
    }

    private static AgvDigitalTwinProtocolRequest inputUpdateStatusFree(final byte[] array, DataInputStream in, final AGVMovement.Methods methods) {
        AgvDigitalTwinProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
            LOGGER.debug(e.getMessage() + "\n");
        }

        request = new UpdateStatusFreeRequest(controller, parsedData, methods);

        return request;
    }

    private static AgvDigitalTwinProtocolRequest inputSharedMemory(final byte[] array, DataInputStream in, final AGVMovement.Methods methods) {

        AgvDigitalTwinProtocolRequest request;

        String parsedData = null;


        request = new SharedMemoryRequest(controller, methods);

        return request;
    }

    private static AgvDigitalTwinProtocolRequest inputUpdateStatusRecharge(final byte[] array, DataInputStream in, final AGVMovement.Methods methods){
        AgvDigitalTwinProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
            LOGGER.debug(e.getMessage() + "\n");
        }

        request = new UpdateStatusRechargeRequest(controller, parsedData, methods);

        return request;
    }

    private static AgvDigitalTwinProtocolRequest inputUpdateStatusRechargeFinishedOrder(final byte[] array, DataInputStream in, final AGVMovement.Methods methods){
        AgvDigitalTwinProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
            LOGGER.debug(e.getMessage() + "\n");
        }

        request = new UpdateStatusRechargeRequest(controller, parsedData, methods);

        return request;
    }

}
