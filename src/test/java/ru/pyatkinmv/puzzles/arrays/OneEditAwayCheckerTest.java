package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.pyatkinmv.puzzles.arrays.OneEditAwayChecker.isOneAway;

public class OneEditAwayCheckerTest {
    @Test
    public void isOneAwayTest() {
        assertTrue(isOneAway("", ""));
        assertTrue(isOneAway("pale", "pale"));
        assertTrue(isOneAway("pale", "ple"));
        assertTrue(isOneAway("pales", "pale"));
        assertTrue(isOneAway("pale", "bale"));
        assertTrue(isOneAway("d", "f"));
        assertTrue(isOneAway("qwerty", "qwer ty"));
        assertFalse(isOneAway("dd", "ff"));
        assertFalse(isOneAway("pale", "bake"));
        assertFalse(isOneAway("b a ke", "b ak e"));
    }
}