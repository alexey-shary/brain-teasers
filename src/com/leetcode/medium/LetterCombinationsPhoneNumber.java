package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        combineLetters(result, digits);
        return result;
    }

    private void combineLetters(List<String> result, String digits) {
        if (digits.length() == 1) {
            result.addAll(Arrays.asList(convertDigit(Integer.valueOf(digits))));
            return;
        }
        combineLetters(result, digits.substring(0, digits.length() - 1));

        List<String> temp = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            String combination = result.get(i);
            String[] letters = convertDigit(Character.getNumericValue(digits.charAt(digits.length() - 1)));
            result.set(i, combination + letters[0]);
            for (int j = 1; j < letters.length; j++) {
                temp.add(combination + letters[j]);
            }
        }
        result.addAll(temp);
    }

    private String[] convertDigit(int digit) {
        switch (digit) {
            case 2:
                return new String[] {"a", "b", "c"};
            case 3:
                return new String[] {"d", "e", "f"};
            case 4:
                return new String[] {"g", "h", "i"};
            case 5:
                return new String[] {"j", "k", "l"};
            case 6:
                return new String[] {"m", "n", "o"};
            case 7:
                return new String[] {"p", "q", "r", "s"};
            case 8:
                return new String[] {"t", "u", "v"};
            case 9:
                return new String[] {"w", "x", "y", "z"};
            default:
                return null;
        }
    }
}
