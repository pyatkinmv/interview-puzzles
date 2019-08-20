package ru.pyatkinmv.puzzles.arrays;

import java.util.Arrays;

public class PermutationChecker {
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return sort(s1).equals(sort(s2));
    }

    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}