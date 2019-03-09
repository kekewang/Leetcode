package com.leetcode.easy;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        int tail = nums.length - 1;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == val) {
                for (;tail >= index; tail--) {
                    if (nums[tail] != val) {
                        nums[index] = nums[tail];
                        nums[tail] = val;
                        len++;
                        break;
                    }
                }
            } else len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int len = new RemoveElement().removeElement(nums, 3);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
