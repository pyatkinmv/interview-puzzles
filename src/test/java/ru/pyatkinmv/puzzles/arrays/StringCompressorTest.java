package ru.pyatkinmv.puzzles.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.pyatkinmv.puzzles.arrays.StringCompressor.compress;

public class StringCompressorTest {
    @Test
    public void compressTest() {
        assertEquals("a2b1c5a3", compress("aabcccccaaa"));
        assertEquals("q3w3e3r3t3y3", compress("qqqwwweeerrrtttyyy"));
        assertEquals("aabccaa", compress("aabccaa"));
        assertEquals("QqQQwww", compress("QqQQwww"));
        assertEquals("Q1q1Q2w5", compress("QqQQwwwww"));
        assertEquals("", compress(""));
        assertEquals("xy", compress("xy"));
        assertEquals("a3", compress("aaa"));
    }
}