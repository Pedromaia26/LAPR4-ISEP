package ordermanager.tcpprotocol.server;

import eapli.base.communicationprotocol.CommunicationProtocol;
import eapli.base.ordermanagement.application.ViewClientOrdersController;
import eapli.base.ordermanagement.application.ViewClientOrdersControllerImpl;
import eapli.base.shoppingcartmanagement.application.ShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartControllerImpl;

public class ViewClientOrder extends OrderManagerProtocolRequest{
    String input;
    String response;

    private ViewClientOrdersController viewClientOrdersController = new ViewClientOrdersControllerImpl();

    protected ViewClientOrder(ViewClientOrdersController controller, String input) {
        super(null, input, controller);
        this.input = input;
    }


    @Override
    public String execute() {

        // execution
        try {
            response = viewClientOrdersController.viewClientOrders(input);
        } catch (Exception e) {
            response = e.getMessage();
        }
        // response
        return response;

    }

    @Override
    public byte[] outputProtocol() {

        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(response);
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.VIEW_CLIENT_ORDERS_RESPONSE, dataLength[0], dataLength[1]};
        return array;
    }
}
