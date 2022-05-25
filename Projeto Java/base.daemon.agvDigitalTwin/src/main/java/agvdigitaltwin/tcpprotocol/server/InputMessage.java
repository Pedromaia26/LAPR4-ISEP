package agvdigitaltwin.tcpprotocol.server;

import eapli.base.agvmanagement.application.AGVManagerController;
import eapli.base.agvmanagement.application.AGVManagerControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public static AgvDigitalTwinProtocolRequest input(final String inputLine) {

        // as a fallback make sure we return unknown
        AgvDigitalTwinProtocolRequest request = new UnknownRequest(inputLine);

        // parse to determine which type of request and if it is sintactally valid

      //  request = inputAssignTask(inputLine);

        return request;
    }


   /* private static AgvDigitalTwinProtocolRequest inputAssignTask(final String inputLine) {
        AgvDigitalTwinProtocolRequest request;


        request = new AssignTaskRequest(controller, inputLine);

        return request;
    }*/

}
