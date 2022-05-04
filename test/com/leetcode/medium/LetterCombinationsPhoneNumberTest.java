package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LetterCombinationsPhoneNumberTest {
    @Test
    public void testLetterCombinations() {
        LetterCombinationsPhoneNumber lcpn = new LetterCombinationsPhoneNumber();
        List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        List<String> actual = lcpn.letterCombinations("23");
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
        expected = new ArrayList<>();
        actual = lcpn.letterCombinations("");
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
        expected = Arrays.asList("a", "b", "c");
        actual = lcpn.letterCombinations("2");
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }
}
