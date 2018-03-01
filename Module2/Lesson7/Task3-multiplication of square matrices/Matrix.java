import java.util.Arrays;

public class Matrix{
    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result = new int[3][3];

    public Matrix(int[][] matrix1, int[][] matrix2){
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    void calculateMultiThread(int n){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[n][i] += (matrix1[n][j] * matrix2[j][i]);
            }
        }
    }

    void calculateSingleThread(){
        cleanArray();
        for (int n = 0; n < 3; n++){
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    result[n][i] += (matrix1[n][j] * matrix2[j][i]);
                }
            }
        }
    }

    void printResult(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void cleanArray(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                result[i][j] = 0;
            }
        }
    }
}