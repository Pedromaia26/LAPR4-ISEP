package daemon.ordermanager;

import daemon.ordermanager.presentation.OrderManagerTcpServer;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class OrderManagerDaemon {

    // TODO read port number from property file
    private static final int BOOKING_PORT = 8898;
    private static final Logger LOGGER = LogManager.getLogger(OrderManagerDaemon.class);

    /**
     * Avoid instantiation of this class.
     */
    private OrderManagerDaemon() {
    }

    public static void main(final String[] args) throws UnknownHostException {


        LOGGER.info("Configuring the daemon");
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        AuthzRegistry.configure(PersistenceContext.repositories().users(),
                new BasePasswordPolicy(),
                new PlainTextEncoder());

        LOGGER.info("Starting the server socket");
        final var server = new OrderManagerTcpServer();
        server.start(BOOKING_PORT, true);

        LOGGER.info("Exiting the daemon");
        System.exit(0);
    }
}
