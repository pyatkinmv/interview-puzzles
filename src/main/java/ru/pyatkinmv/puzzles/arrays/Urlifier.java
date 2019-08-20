package ru.pyatkinmv.puzzles.arrays;

public class Urlifier {
    public static char[] urlify(char[] chars, int n) {
        if (n == 0 || chars.length == 0) {
            return chars;
        }

        int spaces = countSpaces(chars, n);
        int newLength = n + 2 * spaces;
        int j = newLength - 1;
        for (int i = n - 1; i >= 0; --i) {
            if (chars[i] != ' ') {
                chars[j--] = chars[i];
                continue;
            }
            chars[j--] = '0';
            chars[j--] = '2';
            chars[j--] = '%';
        }
        return chars;
    }

    private static int countSpaces(char[] chars, int n) {
        int spaces = 0;
        for (int i = 0; i < n; ++i) {
            if (chars[i] == ' ') {
                ++spaces;
            }
        }
        return spaces;
    }
}
