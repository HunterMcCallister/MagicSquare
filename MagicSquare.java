
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * MagicSquare class is the functionality to verify if a matrix is a magic square and to generate the magic square given
 * the specified size.
 * it supports reading a matrix from a file, checking for the correct properties and writing to a new file.
 * 
 * @author Hunter McCallister
 */
public class MagicSquare implements MagicSquareInterface {

    /**
     * the matrix array that stores the integers making the magic square.
     */
    private int[][] matrix;

    /**
     * Constructs a MagicSquare object by reading a matrix from the file.
     * @param filename name of the file to read the matrix from
     * @throws FileNotFoundException if the file does not exist
     */
    public MagicSquare(String filename) throws FileNotFoundException {
        this.matrix = readMatrix(filename);
    }

   /**
    * Reads a matrix from a file and returns it in a 2D array.
    * @param filename name of the file to read the matrix.
    * @return the matrix a 2D array
    * @throws FileNotFoundException if the file is not found
    */
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

    /**
     * Constructs a MagicSquare object and makes a magic square of a specific size and writes it in a file.
     * 
     * @param filename name of the file where it will be written
     * @param dimension size of the magic square to generate
     * @throws IOException if there is an error writing to the file
     */
    public MagicSquare(String filename, int dimension) throws IOException {
        matrix = new int[dimension][dimension];

        int row = dimension - 1;
        int col = dimension / 2;
        for (int num = 1; num <= dimension * dimension; num++) {
            matrix[row][col] = num;
            int newRow = (row + 1) % dimension;
            int newCol = (col + 1) % dimension;
            if (matrix[newRow][newCol] != 0) {
                row = (row - 1 + dimension) % dimension;
            } else {
                row = newRow;
                col = newCol;
            }
        }
        writeMatrix(matrix, filename);
    }

    /**
     * writes the matrix to a file
     * @param matrix what is being written to a file
     * @param filename file for the matrix to be written on
     * @throws IOException if there is an error writing on the file
     */
    private void writeMatrix(int[][] matrix, String filename) throws IOException {
        try (PrintWriter output = new PrintWriter(filename)) {
            output.println(matrix.length);
            for (int[] row : matrix) {
                for (int value : row) {
                    output.print(value + " ");
                }
                output.println();
            }
        }
    }

    @Override
    public boolean isMagicSquare() {
        int n = matrix.length;
        boolean[] seen = new boolean[n * n];
        int targetSum = n * (n * n + 1) / 2;

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
                if (matrix[i][j] < 1 || matrix[i][j] > n * n) {
                    return false;
                }
                seen[matrix[i][j] - 1] = true;
            }
            if (rowSum != targetSum || colSum != targetSum) {
                return false;
            }
        }

        int diag1Sum = 0, diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][n - 1 - i];
        }
        if (diag1Sum != targetSum || diag2Sum != targetSum) {
            return false;
        }

        for (boolean wasSeen : seen) {
            if (!wasSeen) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int[][] getMatrix() {
        int n = matrix.length;
        int[][] matrixCopy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixCopy[i][j] = matrix[i][j];
            }
        }
        return matrixCopy;
    }

    @Override
    public String toString() {
        String matrixString = "The matrix:\n";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixString += matrix[i][j] + " ";
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
