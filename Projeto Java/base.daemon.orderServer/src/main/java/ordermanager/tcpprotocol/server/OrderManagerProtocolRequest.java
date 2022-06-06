package ordermanager.tcpprotocol.server;

import eapli.base.ordermanagement.application.ViewClientOrdersController;
import eapli.base.ordermanagement.application.ViewClientOrdersControllerImpl;
import eapli.base.shoppingcartmanagement.application.AddProductShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartController;
import eapli.base.shoppingcartmanagement.application.ShoppingCartControllerImpl;

public abstract class OrderManagerProtocolRequest {

    protected final String request;
    protected final ShoppingCartController controller;
    protected final ViewClientOrdersController vController;

    protected OrderManagerProtocolRequest(final ShoppingCartController controller, final String inputRequest, final ViewClientOrdersController vController) {
        this.request = inputRequest;
        this.controller = controller;
        this.vController = vController;
    }

    /** Executes the requested action and builds the response to the client.
        *
             * @return the response to send back to the client
     */
    public abstract String execute();

    public abstract byte[] outputProtocol();

    /** Indicates the object is a goodbye message, that is, a message that will close the
     * connection to the client.
            *
            * @return {@code true} if the object is a a goodbye message.
     */
    public boolean isGoodbye() {
        return false;
    }

    protected String buildServerError(final String errorDescription) {
        final BaseErrorRequest r = new BaseErrorRequest(request, errorDescription) {

            @Override
            public byte[] outputProtocol() {
                return new byte[0];
            }

            @Override
            protected String messageType() {
                return "SERVER_ERROR";
            }

        };
        return r.buildResponse();
    }

    protected String buildBadRequest(final String errorDescription) {
        final BaseErrorRequest r = new BaseErrorRequest(request, errorDescription) {
            @Override
            public byte[] outputProtocol() {
                return new byte[0];
            }

            @Override
            protected String messageType() {
                return "BAD_REQUEST";
            }

        };
        return r.buildResponse();
    }
}
