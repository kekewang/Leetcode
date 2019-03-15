package com.leetcode.medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE, minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1, high = nums.length - 1, a = nums[i];
            while (low < high) {
                int diff = a + nums[low] + nums[high] - target;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    minSum = a + nums[low] + nums[high];
                    if (minDiff == 0) return target;
                    int oldLow = low, oldHigh = high;
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    if (low != oldLow) low--;
                    if (high != oldHigh) high++;
                } else {
                    if (diff > 0) high--;
                    if (diff < 0) low++;
                }
            }
        }
        return minSum;
    }
}
