package com.leetcode.medium;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        Set<List> data = new HashSet<>();
        while (i<=nums.length-3){
            List<Integer> subArr = new ArrayList<>();
            subArr.add(nums[i]);
            int left = i+1, right = nums.length-1;
            while (left<right){
                if (nums[left] + nums[right] + nums[i] > 0){
                    right --;
                }
                else if (nums[left] + nums[right] + nums[i] < 0){
                    left ++;
                }
                else {
                    subArr.add(nums[left]);
                    subArr.add(nums[right]);

                    data.add(subArr);

                    if (left<=right-2){
                        subArr = new ArrayList<>();
                        subArr.add(nums[i]);
                        right--; left++;
                    }
                    else
                        break;
                }
            }
            i++;
        }

        data.stream().forEach(m -> result.add(m));
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-2,0,0,2,2};
        System.out.println(threeSum.threeSum(nums));
    }
}
