package daemon.agvdigitaltwin;

import com.fasterxml.jackson.core.Base64Variant;
import daemon.agvdigitaltwin.presentation.AgvDigitalTwinTcpServer;
import eapli.base.agvmanagement.application.AGVMovement;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class AGVDigitalTwinDaemon {

    // TODO read port number from property file
    private static final int BOOKING_PORT = 8897;
    private static final Logger LOGGER = LogManager.getLogger(AGVDigitalTwinDaemon.class);

    /**
     * Avoid instantiation of this class.
     */
    private AGVDigitalTwinDaemon() {
    }

    public static void main(final String[] args) throws UnknownHostException {

        AGVMovement.Methods methods = new AGVMovement.Methods();
        LOGGER.info("Configuring the daemon");
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(),
                new PlainTextEncoder());

        LOGGER.info("Starting the server socket");
        final var server = new AgvDigitalTwinTcpServer();
        server.start(BOOKING_PORT, true, methods);

        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
