package ru.pyatkinmv.puzzles.arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static ru.pyatkinmv.puzzles.arrays.MatrixZeroer.zero;

public class MatrixZeroerTest {
    private int[][] matrix;
    private int[][] expected;

    @Before
    public void setUp() {
        matrix = new int[][]{
                {5, 10, 15, 20, 25},
                {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23},
                {2, 7, 0, 17, 22},
                {1, 6, 11, 16, 21},
                {0, 5, 10, 15, 20}
        };

        expected = new int[][]{
                {0, 10, 0, 20, 25},
                {0, 9, 0, 19, 24},
                {0, 8, 0, 18, 23},
                {0, 0, 0, 0, 0},
                {0, 6, 0, 16, 21},
                {0, 0, 0, 0, 0}
        };
    }

    @Test
    public void zeroTest() {
        Assert.assertArrayEquals(expected, zero(matrix));
    }
}