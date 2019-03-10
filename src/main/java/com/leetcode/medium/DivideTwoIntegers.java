package com.leetcode.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        while (x >= y) {
            x -= y;
            result++;
        }
        return result * sign;
    }

    /**
     * 一个数92 可以分为48 + 24 + 12 + 6 + 2，即6<<3 + 6<<2 + 6<<1 + 6<0,
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int result = 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        while (x >= y) {
            int shift = 1;

            while (x >= (y << shift)) {
                shift++;
            }
            x -= y << (shift - 1);
            result += 1 << (shift - 1);
        }
        return result * sign;
    }

    public static void main(String[] args) {

        System.out.println(new DivideTwoIntegers().divide(10, 3));
        System.out.println(new DivideTwoIntegers().divide1(92, 6));
    }
}
