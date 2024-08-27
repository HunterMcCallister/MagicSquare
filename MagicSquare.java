
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
        int[][] matrix = new int[dimension][dimension];

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

    public MagicSquare(String filename, int dimension) throws IOException {
        int n = dimension;
        int[][] matrix = new int[n][n];
        int row = n - 1;
        int col = n / 2;
        int oldRow;
        int oldCol;
        for (int i = 1; i <= dimension * dimension; i++) {
            matrix[row][col] = i;
            oldRow = row;
            oldCol = col;
            row--;
            col++;
            if (row < 0) {
                row = n - 1;
            }
            if (col >= n) {
                col = 0;
            }
            if (matrix[row][col] != 0) {
                row = oldRow + 1;
                col = oldCol;
            }
        }

        writeMatrix(matrix, filename);

    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException {
        File readFile = new File(filename);
        PrintWriter pw = new PrintWriter(readFile);
        int n = matrix.length;
        pw.println(n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                pw.print(matrix[row][col]);
                if (col < n - 1) {
                    pw.print(" ");
                }
            }
            pw.println();
        }
        pw.close();

    }

    @Override
    public boolean isMagicSquare() {
        int targetSum = 0;
        for (int col = 0; col < matrix.length; col++) {
            targetSum += matrix[0][col];
        }
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            int colSum = 0;

            for (int j = 0; j < matrix.length; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != targetSum || colSum != targetSum) {
                return false;
            }
        }
        int diagSum1 = 0;
        int diagSum2 = 0;

        for (int i = 0; i < matrix.length; i++) {
            diagSum1 += matrix[i][i];
            diagSum2 += matrix[i][matrix.length - i - 1];
        }
        if (diagSum1 != targetSum || diagSum2 != targetSum) {
            return false;
        }
        return true;

    }

    @Override
    public int[][] getMatrix() {
        int n = matrix.length;
        int[][] matrixCopy = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrixCopy[i][j] = matrix [i][j];
            }
        }
        return matrixCopy;
    }

    @Override
    public String toString() {
        String matrixString = "The Matrix:\n";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixString = matrix[i][j] + " ";
            }
            matrixString += "\n";
        }
        if (isMagicSquare()) {
            matrixString += "is a magic square.";
        } else {
            matrixString += "is not a magic square.";
        }
        return matrixString;
        }

    }


