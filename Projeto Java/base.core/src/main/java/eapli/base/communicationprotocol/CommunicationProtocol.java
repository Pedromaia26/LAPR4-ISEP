package eapli.base.communicationprotocol;

public class CommunicationProtocol {

    public static final byte[] COMM_TEST_V1 = {1,0,0,0};
    public static final byte[] DISCONN_TEST_V1 = {1,1,0,0};
    public static final byte[] ACK_MESSAGE_V1 = {1,2,0,0};
    public static final byte[] ASSIGN_AGV_TO_ORDER_V1 = {1,100,0,0};
    public static final byte[] ASSIGN_AGV_TO_ORDER_REPONSE_V1 = {1,101,0,0};
    public static final int PROTOCOL_V1 = 1;

    public static final int COMM_TEST_CODE = 0;
    public static final int DISCONN_CODE = 1;
    public static final int ACK_CODE = 2;
    public static final int ASSIGN_AGV_TO_ORDER_CODE = 100;
    public static final int ASSIGN_AGV_TO_ORDER_REPONSE_CODE = 101;



    public static byte[] dataLengthCalculator(String data){
        int dataLength = data.length();

        if(dataLength<256)
            return new byte[]{(byte)dataLength, 0};

        int numBytes = 0;
        while(dataLength > 255){
            numBytes++;
            dataLength-=256;
        }

        return new byte[]{(byte)dataLength, (byte)numBytes};
    }

}

