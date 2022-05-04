package com.ctci.chapter1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckPermutation {
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        List c1 = s1.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());
        List c2 = s2.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList());

        if (c1.equals(c2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPermutationOptimized(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        // Assuming that ASCII characters are used <-- TODO: clarify
        int[] charSet = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            charSet[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (--charSet[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
