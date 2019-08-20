import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.pyatkinmv.puzzles.rotator.MatrixRotator;

public class MatrixRotatorTest {
    private MatrixRotator rotator;
    private int[][] counterClockwiseExpected;
    private int[][] clockwiseExpected;

    @Before
    public void setUp() {
        rotator = new MatrixRotator();

        clockwiseExpected = new int[][]{
                {5, 10, 15, 20, 25},
                {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23},
                {2, 7, 12, 17, 22},
                {1, 6, 11, 16, 21},
                {0, 5, 10, 15, 20}
        };
        counterClockwiseExpected = new int[][]{
                {20, 15, 10, 5, 0},
                {21, 16, 11, 6, 1},
                {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4},
                {25, 20, 15, 10, 5},
        };
    }

    @Test
    public void testRotateClockwise() {
        testRotate(true);
    }

    @Test
    public void testRotateCounterClockwise() {
        testRotate(false);
    }

    private void testRotate(boolean clockwise) {
        int[][] matrix = createMatrix(5, 6);
        int[][] expected = clockwise ? clockwiseExpected : counterClockwiseExpected;
        int[][] actual = rotator.rotate(matrix, clockwise);
        Assert.assertArrayEquals(expected, actual);
    }

    private int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                matrix[i][j] = i * rows + j;
            }
        }
        return matrix;
    }
}
