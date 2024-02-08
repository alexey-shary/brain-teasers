package com.leetcode.medium;

import java.util.*;

/**
 * 139. Word Break
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {
    private final Map<String, Boolean> memo = new HashMap();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (memo.get(s) != null) return memo.get(s);
        for (String prefix: wordDict) {
            if (s.startsWith(prefix)) {
                boolean result = wordBreak(s.substring(prefix.length()), wordDict);
                if (result) return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
