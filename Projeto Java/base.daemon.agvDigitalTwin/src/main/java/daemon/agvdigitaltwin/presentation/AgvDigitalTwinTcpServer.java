package daemon.agvdigitaltwin.presentation;

import agvdigitaltwin.tcpprotocol.server.AgvDigitalTwinProtocolRequest;
import agvdigitaltwin.tcpprotocol.server.InputMessage;
import eapli.base.agvmanagement.application.AGVMovement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class AgvDigitalTwinTcpServer {


    private static final Logger LOGGER = LogManager.getLogger(AgvDigitalTwinTcpServer.class);
    private static final String TRUSTED_STORE_SERVER = "certificates/server.jks";
    private static final String TRUSTED_STORE_CLIENT = "certificates/client.jks";
    private static final String KEYSTORE_PASS = "Password1";




    private static class AgvDigitalTwinHandler extends Thread {

        private final AGVMovement.Methods methods;
        private Socket clientSocket;

        public AgvDigitalTwinHandler(final Socket socket, final AGVMovement.Methods methods) {
            this.clientSocket = socket;
            this.methods = methods;
        }

        @Override
        public void run() {

            final var clientIP = clientSocket.getInetAddress();

            LOGGER.debug("Accepted connection from {}:{}", clientIP.getHostAddress(), clientSocket.getPort());

            try (var out = new DataOutputStream(clientSocket.getOutputStream());
                 var in = new DataInputStream(clientSocket.getInputStream())) {

                byte [] array_comm_test = in.readNBytes(4);
                LOGGER.debug("Initial request message received");
                InputMessage.parseMessage(array_comm_test, in, out, methods);
                LOGGER.debug("Response from initial request sent\n");

                byte[] array = in.readNBytes(4);
                LOGGER.debug("Received message: {}", array);
                final AgvDigitalTwinProtocolRequest request = InputMessage.parseMessage(array, in, out, methods);
                final String response = request.execute();
                final byte[] responseByte = request.outputProtocol();
                out.write(responseByte);
                out.write(response.getBytes(StandardCharsets.UTF_8));
                LOGGER.debug("Sent message: {}\n", response);

                byte [] array_end_of_session = in.readNBytes(4);
                LOGGER.debug("End of session request");
                InputMessage.parseMessage(array_end_of_session, in, out, methods);
                LOGGER.debug("End of session request received\n");

            } catch (final IOException e) {
                LOGGER.error(e);
            } finally {
                try {
                    clientSocket.close();
                    LOGGER.debug("Closing client socket {}:{}", clientIP.getHostAddress(), clientSocket.getPort());
                } catch (final IOException e) {
                    LOGGER.error("While closing the client socket {}:{}", clientIP.getHostAddress(),
                            clientSocket.getPort(), e);
                }
                // null the reference to ensure it will be caught by the garbage collector
                clientSocket = null;

                // helper debug - SHOULD NOT BE USED IN PRODUCTION CODE!!!
                if (LOGGER.isDebugEnabled()) {
                    final int finalThreadCount = Thread.activeCount();
                    LOGGER.debug("Ending client thread - final thread count: {}", finalThreadCount);
                    final Thread[] t = new Thread[finalThreadCount];
                    final int n = Thread.enumerate(t);
                    for (var i = 0; i < n; i++) {
                        LOGGER.debug("T {}: {}", t[i].getId(), t[i].getName());
                    }
                }
            }
        }
    }



    /**
     * Wait for connections.
     * <p>
     * Suppress warning java:S2189 - Loops should not be infinite
     *
     * @param port
     */
    @SuppressWarnings("java:S2189")
    private void listen(final int port, final AGVMovement.Methods methods) {

        SSLServerSocket serverSocket = null;

        //Trust the cert provided by authorized clients

        System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE_CLIENT);
        System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);


        //Use this certificate and private key as Server certificate
        System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE_SERVER);
        System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);

        SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            serverSocket = (SSLServerSocket) sslF.createServerSocket(port);
            // serverSocket.setNeedClientAuth(true);
        }
        catch(IOException ex) {
            LOGGER.debug("Server failed to open local port " + port + "\n");
            System.exit(1);
        }

        try {
            while (true) {
                final var clientSocket = serverSocket.accept();
                new AgvDigitalTwinHandler(clientSocket, methods).start();
            }
        } catch (final IOException e) {
            LOGGER.error(e);
        }
    }

    /**
     * Wait for connections.
     *
     * @param port
     * @param blocking
     *            if {@code false} the socket runs in its own thread and does not block calling
     *            thread.
     */
    public void start(final int port, final boolean blocking, final AGVMovement.Methods methods) {
        if (blocking) {
            listen(port, methods);
        } else {
            new Thread(() -> listen(port, methods)).start();
        }
    }
}

