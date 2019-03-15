package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int s = nums[j];
                int sum1 = f + s;

                int k1 = j + 1, k2 = nums.length - 1;
                while (k1 < k2) {
                    int total = sum1 + nums[k1] + nums[k2];

                    if (total == target) {
                        res.add(Arrays.asList(f, s, nums[k1], nums[k2]));

                        // skip duplicates of third and fourth nums
                        while (k1 + 1 < k2 && nums[k1] == nums[k1 + 1]) k1++;
                        while (k2 - 1 > k1 && nums[k2] == nums[k2 - 1]) k2--;

                        k1++;
                        k2--;
                    } else if (total > target) {
                        k2--;
                    } else k1++;
                }
                // skip duplicates of second num
                while (j + 1 < nums.length && s == nums[j + 1]) j++;
            }
            // skip duplicates of first num
            while (i + 1 < nums.length && f == nums[i + 1]) i++;
        }
        return res;
    }
}
