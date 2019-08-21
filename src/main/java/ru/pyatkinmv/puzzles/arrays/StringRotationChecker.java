package ru.pyatkinmv.puzzles.arrays;

public class StringRotationChecker {
    public static boolean isRotation(String origin, String rotation) {
        return origin.length() == rotation.length() && isSubstring(origin + origin, rotation);
    }

    public static boolean isSubstring(String origin, String substring) {
        int originLen = origin.length();
        int substrLen = substring.length();
        if (substrLen == 0) {
            return true;
        }
        if (originLen < substrLen) {
            return false;
        }

        for (int i = 0; i < originLen; ++i) {
            for (int j = 0; i + j < originLen; ++j) {
                if (origin.charAt(i + j) != substring.charAt(j)) {
                    break;
                }
                if (j + 1 == substrLen) {
                    return true;
                }
            }
        }

        return false;
    }
}
