package ru.pyatkinmv.puzzles.arrays;

import static java.lang.Math.abs;

public class OneEditAwayChecker {
    public static boolean isOneAway(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (abs(len1 - len2) > 1) {
            return false;
        }

        boolean differ = false;
        int i1 = 0;
        int i2 = 0;
        while (i1 < len1 && i2 < len2) {
            if (s1.charAt(i1) != s2.charAt(i2)) {
                if (differ) {
                    return false;
                }
                differ = true;
                if (len1 > len2) {
                    --i2;
                } else if (len2 > len1) {
                    --i1;
                }
            }
            ++i1;
            ++i2;
        }
        return true;
    }
}
