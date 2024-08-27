
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MagicSquare implements MagicSquareInterface {

    private int[][] matrix;

    public MagicSquare(String filename) throws FileNotFoundException {
        this.matrix = readMatrix(filename);
    }

    private int[][] readMatrix(String filename) throws FileNotFoundException {
        File matrixFile = new File(filename);
        Scanner fileScan = new Scanner(matrixFile);
        int dimension = fileScan.nextInt();
        int[][]matrix = new int[dimension][dimension];

        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                if (fileScan.hasNextInt()) {
                    matrix[row][col] = fileScan.nextInt();
                }
            }
        }
        fileScan.close();
        return matrix;

    }
     public MagicSquare(String filename, int dimension) throws IOException{
        int n = dimension;
        int[][] matrix = new int[n][n];
        int row = n - 1;
        int col = n / 2;
        int oldRow;
        int oldCol;
        for(int i = 1; i <= dimension * dimension; i++){
            matrix[row][col] = i;
            oldRow = row;
            oldCol = col;
            row--;
            col++;
            if (row < 0){
                row = n - 1;
            }
            if (col >= n){
                col = 0;
            }
            if (matrix[row][col] != 0){
                row = oldRow + 1;
                col = oldCol;
            }
        }


     }
     private void writeMatrix(int[][] matrix, String filename) throws IOException{
        
     }

    @Override
    public boolean isMagicSquare() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int[][] getMatrix() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return null;

    }

}
