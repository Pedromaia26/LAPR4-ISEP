package eapli.base.agvmanagement.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MatrixControllerImpl implements MatrixController{

    private static final Logger LOGGER = LogManager.getLogger(MatrixControllerImpl.class);

    StringBuilder string = new StringBuilder();
    @Override
    public StringBuilder matrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                LOGGER.debug(matrix[i][j] + " ");
                }
            LOGGER.debug("\n");
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
             if (matrix[i][j] == 9){
                 string.append(i);
                 string.append(",");
                 string.append(j);
                 string.append(";");
             }
            }
        }
        return string;
    }
}
