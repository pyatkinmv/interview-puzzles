package ru.pyatkinmv.puzzles.arrays;

import java.util.Arrays;

public class CharsUniqueChecker {
    public static boolean isUniqueChars(String str) {
        char[] chars = Arrays.copyOf(str.toCharArray(), str.length());
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; ++i) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
