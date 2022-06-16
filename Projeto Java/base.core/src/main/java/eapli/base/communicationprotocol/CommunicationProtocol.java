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
    public static final int UPDATE_AGV_STATUS_CODE = 102;
    public static final int UPDATE_AGV_STATUS_RESPONSE_CODE = 103;
    public static final int ADD_PRODUCT_SHOPPING_CART_CODE = 104;
    public static final int ADD_PRODUCT_SHOPPING_CART_RESPONSE_CODE = 105;
    public static final int FREE_AGV_CODE = 106;
    public static final int FREE_AGV_RESPONSE_CODE = 107;
    public static final int UPDATE_AGV_STATUS_FREE_CODE = 108;
    public static final int UPDATE_AGV_STATUS_FREE_RESPONSE_CODE = 109;
    public static final int DASHBOARD_TO_AGVMANAGER_CODE = 110;
    public static final int DASHBOARD_TO_AGVMANAGER_RESPONSE_CODE = 111;
    public static final int DASHBOARD_CODE = 112;
    public static final int DASHBOARD_RESPONSE_CODE = 113;
    public static final int VIEW_CLIENT_ORDERS = 114;
    public static final int VIEW_CLIENT_ORDERS_RESPONSE = 115;
    public static final int SHARED_MEMORY = 116;
    public static final int SHARED_MEMORY_RESPONSE = 117;
    public static final int RECHARGING_AGV_CODE = 118;
    public static final int RECHARGING_AGV_RESPONSE_CODE = 119;
    public static final int UPDATE_AGV_STATUS_RECHARGE_CODE = 120;
    public static final int UPDATE_AGV_STATUS_RECHARGE_RESPONSE_CODE = 121;
    public static final int UPDATE_AGV_STATUS_RECHARGE_FINISHED_ORDER_CODE = 122;
    public static final int UPDATE_AGV_STATUS_RECHARGE_FINISHED_ORDER_RESPONSE_CODE = 123;
    public static final int AGV_RECHARGE_FINISHED_ORDER_CODE = 124;
    public static final int AGV_RECHARGE_FINISHED_ORDER_RESPONSE_CODE = 125;
    public static final int UPDATE_AGV_STATUS_MAINTENANCE_CODE = 126;
    public static final int UPDATE_AGV_STATUS_MAINTENANCE_RESPONSE_CODE = 127;

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

