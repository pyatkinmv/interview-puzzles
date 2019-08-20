package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.arrays.CharsUniqueChecker.isUniqueChars;

public class CharsUniqueCheckerTest {
    @Test
    public void isUniqueCharsTest() {
        assertTrue(isUniqueChars("asdfg132q"));
        assertTrue(isUniqueChars("12345abcd67890efg"));
        assertTrue(isUniqueChars(""));
        assertFalse(isUniqueChars("qwertyy"));
        assertFalse(isUniqueChars("q_1t23yerhq"));
        assertFalse(isUniqueChars("111222"));
    }
}