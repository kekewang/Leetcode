package com.leetcode.easy;

import com.leetcode.medium.Pow;

/**
 * Created by wangke on 2018/10/22.
 *
 * Implement int sqrt(int x).

 Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

 Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

 Example 1:

 Input: 4
 Output: 2
 Example 2:

 Input: 8
 Output: 2
 Explanation: The square root of 8 is 2.82842..., and since
 the decimal part is truncated, 2 is returned.

 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x / mid >= mid) left = mid + 1;
            else right = mid;
        }
        return right - 1;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();

        System.out.println(sqrt.mySqrt(8));
    }
}
