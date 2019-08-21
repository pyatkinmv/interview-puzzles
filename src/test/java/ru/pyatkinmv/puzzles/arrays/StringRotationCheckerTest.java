package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.arrays.StringRotationChecker.isRotation;
import static ru.pyatkinmv.puzzles.arrays.StringRotationChecker.isSubstring;

public class StringRotationCheckerTest {
    @Test
    public void isRotationTest() {
        assertTrue(isRotation("waterbottle", "erbottlewat"));
        assertTrue(isRotation("", ""));
        assertTrue(isRotation("asdhfa Rse", "seasdhfa R"));
        assertTrue(isRotation("abc", "cab"));
        assertFalse(isRotation("abc", "bac"));
        assertFalse(isRotation("asdhfa Rsep", "asdhfa Rse"));
        assertFalse(isRotation("asdhfa Rse", "asdhfa Rsep"));
        assertFalse(isRotation("waterbottle", "erbottlewar"));
    }

    @Test
    public void isSubstringTest() {
        assertTrue(isSubstring("abcdefg", "def"));
        assertTrue(isSubstring("Qasdfndhdfghd dfg23rt dfg __ 1%", "Qasdfndhdfghd dfg23rt dfg __ 1%"));
        assertTrue(isSubstring("Qasdfndhdfghd dfg23rt dfg __ 1%", "23rt dfg __ 1%"));
        assertTrue(isSubstring("", ""));
        assertFalse(isSubstring("abcdeqfg", "def"));
        assertFalse(isSubstring("abcdeqfg", "def"));
        assertFalse(isSubstring("qwerty", "qwertyu"));
        assertFalse(isSubstring("zxcvbnm", "zxcv "));
    }

}