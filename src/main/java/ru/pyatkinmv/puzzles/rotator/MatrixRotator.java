package ru.pyatkinmv.puzzles.rotator;

public class MatrixRotator implements Rotator<int[][]> {
    @Override
    public int[][] rotate(int[][] matrix, boolean clockwise) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] rotated = new int[width][height];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (clockwise) {
                    rotated[width - j - 1][i] = matrix[i][j];
                } else {
                    rotated[j][height - i - 1] = matrix[i][j];
                }
            }
        }
        return rotated;
    }
}
