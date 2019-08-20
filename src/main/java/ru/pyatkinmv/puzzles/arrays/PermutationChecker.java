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

    public static boolean isPalindromPermutation(String s) {
        String sortedCompressed = sort(s.replaceAll(" ", ""));
        int length = sortedCompressed.length();
        if (length <= 2) {
            return true;
        }

        int countOfOddLetters = 0;
        int letterCount = 0;
        char letter = sortedCompressed.charAt(0);
        for (int i = 0; i < length; ++i) {
            if (sortedCompressed.charAt(i) == letter) {
                letterCount++;
                continue;
            }
            letter = sortedCompressed.charAt(i);
            countOfOddLetters = isOdd(letterCount) ? countOfOddLetters + 1 : countOfOddLetters;
            letterCount = 1;
        }
        return countOfOddLetters == 0 || (countOfOddLetters == 1 && isOdd(length));
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}