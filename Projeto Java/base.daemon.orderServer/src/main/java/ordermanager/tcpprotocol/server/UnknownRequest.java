package ordermanager.tcpprotocol.server;

public class UnknownRequest extends BaseErrorRequest {

    public UnknownRequest(final String inputLine) {
        super(inputLine);
    }

    @Override
    protected String messageType() {
        return "UNKNOWN_REQUEST";
    }

    @Override
    public byte[] outputProtocol() {
        return new byte[0];
    }
}
