package com.ctci.chapter1;

/**
 * 1.1 - Is Unique - page 90
 */
public class UniqueCharacters {
    public boolean isUnique(String s) {
        // Assuming that ASCII characters are used <-- TODO: clarify
        boolean[] ascii = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (ascii[(int) c]) {
                return false;
            } else {
                ascii[(int) c] = true;
            }
        }
        return true;
    }
}
