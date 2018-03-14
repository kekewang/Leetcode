package com.leetcode.easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output:  321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Created by wangke on 2018/3/14.
 */
public class ReverseInteger {

    public int reverse(int x) {
        return reverseUnsign(0, x);
    }

    private int reverseUnsign(int upper, int x) {
        int quotient = x / 10;
        int remainder = x % 10;
        if (quotient == 0) {
            long result = upper * 10L + remainder;
            return result>Integer.MAX_VALUE?0: (int) (result < Integer.MIN_VALUE ? 0 : result);
        }

        int sum = reverseUnsign(upper * 10 + remainder, quotient);
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(123));
    }
}
