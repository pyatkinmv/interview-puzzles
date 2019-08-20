package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.arrays.PermutationChecker.isPalindromPermutation;
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

    @Test
    public void isPalindromPermutationTest() {
        assertTrue(isPalindromPermutation("tact coa"));
        assertTrue(isPalindromPermutation("tact coao"));
        assertTrue(isPalindromPermutation("taco cat"));
        assertTrue(isPalindromPermutation("atco cta"));
        assertTrue(isPalindromPermutation("1 e t y 21 ygt ge"));
        assertTrue(isPalindromPermutation(""));
        assertTrue(isPalindromPermutation("a  b"));
        assertTrue(isPalindromPermutation("x"));
        assertFalse(isPalindromPermutation("tact coat"));
        assertFalse(isPalindromPermutation("qwerty12ytrewq"));
    }
}