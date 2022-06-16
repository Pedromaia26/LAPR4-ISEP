package ordermanager.tcpprotocol.server;

import eapli.base.communicationprotocol.CommunicationProtocol;
import eapli.base.ordermanagement.application.ViewClientOrdersController;
import eapli.base.ordermanagement.application.ViewClientOrdersControllerImpl;
import eapli.base.shoppingcartmanagement.application.ShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InputMessage {

    private static final Logger LOGGER = LogManager.getLogger(InputMessage.class);

    private static final Object lock = new Object();

    private static ShoppingCartController controller = new ShoppingCartControllerImpl();
    private static ViewClientOrdersController vController = new ViewClientOrdersControllerImpl();

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

    public static OrderManagerProtocolRequest parseMessage(byte[] arr, DataInputStream in, DataOutputStream dataOutputStream) throws IOException {

        OrderManagerProtocolRequest agvManagerProtocolRequest = null;

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.COMM_TEST_CODE) {
            dataOutputStream.write(CommunicationProtocol.ACK_MESSAGE_V1);
            dataOutputStream.flush();
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.DISCONN_CODE) {
            dataOutputStream.write(CommunicationProtocol.ACK_MESSAGE_V1);
            dataOutputStream.flush();
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.ADD_PRODUCT_SHOPPING_CART_CODE) {

            agvManagerProtocolRequest = inputAddProduct(arr, in);
        }

        if (arr[0] == CommunicationProtocol.PROTOCOL_V1 && arr[1] == CommunicationProtocol.VIEW_CLIENT_ORDERS) {

            agvManagerProtocolRequest = inputViewOrder(arr, in);
        }

        return agvManagerProtocolRequest;
    }

    private static OrderManagerProtocolRequest inputAddProduct(final byte[] array, DataInputStream in) {
        OrderManagerProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
           LOGGER.debug(e.getMessage() + "\n");
        }

        request = new AddProductShoppingCart(controller, parsedData);

        return request;
    }

    private static OrderManagerProtocolRequest inputViewOrder(final byte[] array, DataInputStream in) {
        OrderManagerProtocolRequest request;

        String parsedData = null;


        int dataLength = array[2] + 256*array[3];

        try {
            byte[] data = in.readNBytes(dataLength);
            parsedData = new String(data);
        }catch (Exception e){
            LOGGER.debug(e.getMessage() + "\n");
        }

        request = new ViewClientOrder(vController, parsedData);

        return request;
    }

}
