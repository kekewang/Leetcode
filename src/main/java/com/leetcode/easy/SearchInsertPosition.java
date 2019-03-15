package com.leetcode.easy;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) >> 1;
        while (left <= right) {
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) >> 1;
        }
        return left;
    }
}
