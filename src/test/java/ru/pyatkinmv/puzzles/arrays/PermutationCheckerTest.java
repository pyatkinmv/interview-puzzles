package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.arrays.PermutationChecker.isPermutation;

public class PermutationCheckerTest {

    @Test
    public void isPermutationTest() {
        assertTrue(isPermutation("aqwsderf", "frdeaqws"));
        assertTrue(isPermutation("dog", "god"));
        assertTrue(isPermutation("", ""));
        assertFalse(isPermutation("dog", "God"));
        assertFalse(isPermutation("qwerty", "qwert"));
    }
}