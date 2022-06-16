package agvdigitaltwin.tcpprotocol.server;

import eapli.base.agvmanagement.application.*;
import eapli.base.communicationprotocol.CommunicationProtocol;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SharedMemoryRequest extends AgvDigitalTwinProtocolRequest{

    private MatrixController matrixController = new MatrixControllerImpl();
    private AGVMovement.Methods methods;
    private static final Logger LOGGER = LogManager.getLogger(SharedMemoryRequest.class);


    private int[][] matrix;
    private String matrix2;

    protected SharedMemoryRequest(AGVManagerController controller, AGVMovement.Methods methods) {
        super(controller, null);
        this.methods = methods;
    }


    @Override
    public String execute() {

        // semantic validation
        matrix = methods.Matrix();

       /* for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }*/

        try {
            matrix2 = String.valueOf(matrixController.matrix(matrix));
        }catch (Exception e){
            matrix2 = e.getMessage();
        }
        // execution
        LOGGER.debug(matrix2 + "\n");

        // response
        return matrix2;
    }

    @Override
    public byte[] outputProtocol() {
        byte[] dataLength = CommunicationProtocol.dataLengthCalculator(matrix2);
        byte[] array = new byte[]{CommunicationProtocol.PROTOCOL_V1,
                CommunicationProtocol.SHARED_MEMORY_RESPONSE, dataLength[0], dataLength[1]};
        return array;
    }
}
