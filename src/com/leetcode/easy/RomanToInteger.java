package com.leetcode.easy;

import java.util.HashMap;

/**
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 *
 */
public class RomanToInteger {
    private static HashMap<String, Integer> translations = new HashMap<>();

    static {
        translations.put("I", 1);
        translations.put("V", 5);
        translations.put("X", 10);
        translations.put("L", 50);
        translations.put("C", 100);
        translations.put("D", 500);
        translations.put("M", 1000);

        translations.put("IV", 4);
        translations.put("IX", 9);
        translations.put("XL", 40);
        translations.put("XC", 90);
        translations.put("CD", 400);
        translations.put("CM", 900);
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (i != s.length() - 1 && translations.get(s.substring(i, i + 2)) != null) {
                result += translations.get(s.substring(i, i + 2));
                i++;
            } else {
                result += translations.get(c);
            }
        }
        return result;
    }
}
