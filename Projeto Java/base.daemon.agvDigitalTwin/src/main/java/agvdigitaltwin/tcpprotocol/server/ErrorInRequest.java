package agvdigitaltwin.tcpprotocol.server;

public class ErrorInRequest extends BaseErrorRequest{

    public ErrorInRequest(final String request, final String errorDescription) {
        super(request, errorDescription);
    }

    @Override
    protected String messageType() {
        return "ERROR_IN_REQUEST";
    }

    @Override
    public byte[] outputProtocol() {
        return new byte[0];
    }
}
