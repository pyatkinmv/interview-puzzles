package ru.pyatkinmv.puzzles.arrays;

public class MatrixZeroer {
    public static int[][] zero(int[][] matrix) {
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            if (zeroRows[i]) {
                continue;
            }
            for (int j = 0; j < matrix[0].length; ++j) {
                if (zeroCols[j]) {
                    continue;
                }
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        return zero(matrix, zeroRows, zeroCols);
    }

    private static int[][] zero(int[][] matrix, boolean[] zeroRows, boolean[] zeroCols) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
