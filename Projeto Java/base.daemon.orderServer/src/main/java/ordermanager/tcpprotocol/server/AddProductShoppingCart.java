package ordermanager.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import eapli.base.communicationprotocol.CommunicationProtocol;
import eapli.base.shoppingcartmanagement.application.AddProductShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartControllerImpl;

public class AddProductShoppingCart extends OrderManagerProtocolRequest {
    String input;

    private ShoppingCartController shoppingCartController = new ShoppingCartControllerImpl();

    protected AddProductShoppingCart(ShoppingCartController controller, String input) {
        super(controller, input);
        this.input = input;
    }


    @Override
    public String execute() {

        String response;

        // execution
        try {
            shoppingCartController.addProductShoppingCart(input);
            response = buildResponse();
        } catch (Exception e) {
            response = e.getMessage();

        }
        // response
        return response;

    }

    @Override
    public byte[] outputProtocol() {

        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(buildResponse());
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.ADD_PRODUCT_SHOPPING_CART_RESPONSE_CODE, dataLength[0], dataLength[1]};
        return array;
    }

    private String buildResponse() {
        return "Product added to the shopping cart";
    }
}
