package com.leetcode.medium;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 *
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 * The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = Arrays.stream(piles).max().getAsInt();
        while (start < end) {
            int middle = start + (end - start) / 2;
            if (kokoEatsInTime(piles, h, middle)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    private boolean kokoEatsInTime(int[] piles, int h, int k) {
        int hoursToEat = 0;
        for (int bananas: piles) {
            hoursToEat += bananas / k;
            if (bananas % k != 0) {
                hoursToEat++;
            }
        }
        return hoursToEat <= h;
    }
}
