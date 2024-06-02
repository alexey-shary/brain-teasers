package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * String Encode and Decode
 *
 * Design an algorithm to encode a list of strings to a single string.
 * The encoded string is then decoded back to the original list of strings.
 */
public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s: strs) {
            sb.append((char) s.length()).append(s); // Java stores each char as a 16-bit Unicode encoded value
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int wordLength = str.charAt(i); // Java stores each char as a 16-bit Unicode encoded value
            i++;
            result.add(str.substring(i, i + wordLength));
            i += wordLength;
        }

        return result;
    }
}
