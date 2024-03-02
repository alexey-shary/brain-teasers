package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        // Check obvious conditions first
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                frequencies.merge(board[i][j], 1, Integer::sum);
            }
        }
        for (char c: word.toCharArray()) {
            if (frequencies.get(c) == null || frequencies.get(c) < 0) {
                return false;
            } else {
                frequencies.merge(c, -1, Integer::sum);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int index) {
        if (word.length() == index) {
            return true;
        }

        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = '#';
        if (search(board, word, i - 1, j, index + 1) || search(board, word, i + 1, j, index + 1) || search(board, word, i, j - 1, index + 1) || search(board, word, i, j + 1, index + 1)) {
            return true;
        }
        board[i][j] = word.charAt(index);

        return false;
    }
}
