package agvmanager.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.communicationprotocol.CommunicationProtocol;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;


public class InputMessage {

    private static Socket socket;
    private static DataOutputStream agvSOut;
    private static DataInputStream agvSIn;
    private static BufferedInputStream agvBufferedIn;
    private static BufferedOutputStream agvBufferedOut;
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

    public static AgvManagerProtocolRequest parseMessage(byte[] arr, DataInputStream in, DataOutputStream dataOutputStream) throws IOException {

        AgvManagerProtocolRequest agvManagerProtocolRequest = null;

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.COMM_TEST_CODE) {
            dataOutputStream.write(CommunicationProtocol.ACK_MESSAGE_V1);
            dataOutputStream.flush();
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.DISCONN_CODE) {
            dataOutputStream.write(CommunicationProtocol.ACK_MESSAGE_V1);
            dataOutputStream.flush();
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.ASSIGN_AGV_TO_ORDER_CODE) {

            agvManagerProtocolRequest = inputAssignTask(arr, in);
        }
        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.FREE_AGV_CODE) {

            agvManagerProtocolRequest = inputUpdateStatus(arr, in);
        }


        return agvManagerProtocolRequest;
    }


    public static AgvManagerProtocolRequest inputAssignTask(final byte[] array, DataInputStream in) throws IOException {

        AgvManagerProtocolRequest request;



        request = new AssignTaskRequest(controller);

        return request;
    }

    private static AgvManagerProtocolRequest inputUpdateStatus(final byte[] array, DataInputStream in) {
        AgvManagerProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        request = new FreeAGVRequest(controller, parsedData);

        return request;
    }



}
