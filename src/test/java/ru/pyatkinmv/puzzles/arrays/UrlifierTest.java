package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static ru.pyatkinmv.puzzles.arrays.Urlifier.urlify;

public class UrlifierTest {
    @Test
    public void urlifyTest() {
        assertArrayEquals("Mr%20John%20Smith".toCharArray(), urlify("Mr John Smith    ".toCharArray(), 13));
        assertArrayEquals("a%20b%20c%20d%20e%20f%20g%20h".toCharArray(),
                urlify("a b c d e f g h              ".toCharArray(), 15));
        assertArrayEquals("".toCharArray(), urlify("".toCharArray(), 5));
        assertArrayEquals("qwerty".toCharArray(), urlify("qwerty".toCharArray(), 0));
    }
}