package daemon.agvmanager;

import daemon.agvmanager.presentation.AgvManagerTcpServer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.Socket;


public class AGVManagerDaemon {

    // TODO read port number from property file
    private static final int BOOKING_PORT = 8899;
    private static final Logger LOGGER = LogManager.getLogger(AGVManagerDaemon.class);

    /**
     * Avoid instantiation of this class.
     */
    private AGVManagerDaemon() {
    }

    public static void main(final String[] args) {


        LOGGER.info("Configuring the daemon");

        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(),
                new PlainTextEncoder());

        LOGGER.info("Starting the server socket");
        final var server = new AgvManagerTcpServer();
        server.start(BOOKING_PORT, true);

        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
