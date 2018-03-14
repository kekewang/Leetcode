package com.questions.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 * Created by wangke on 2018/3/6.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int index=0; index<nums.length; index++){
            if (!map.containsKey(target-nums[index]))
                map.put(target-nums[index], index);
        }

        for (int index=nums.length-1; index>=0; index--){
            if (map.get(nums[index])!=null &&
                    index!=map.get(nums[index])){
                return new int[]{map.get(nums[index]), index};
            }
        }

        return null;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,5,5,11};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, 10);
        for (int value : result)
            System.out.print(value);
    }
}
