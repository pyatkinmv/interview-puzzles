package ru.pyatkinmv.puzzles.arrays;

public class StringCompressor {
    public static String compress(String s) {
        int len = s.length();
        if (len <= 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char letter = s.charAt(0);
        int letterCount = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) != letter) {
                sb.append(letter);
                sb.append(letterCount);
                letter = s.charAt(i);
                letterCount = 1;
                continue;
            }
            ++letterCount;
        }
        sb.append(letter);
        sb.append(letterCount);

        return sb.length() < len ? sb.toString() : s;
    }
}
