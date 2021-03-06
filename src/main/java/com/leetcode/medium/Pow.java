package com.leetcode.medium;

/**
 * Created by wangke on 2018/10/22.
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 Note:

 -100.0 < x < 100.0
 n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Pow {

    public double myPow(double x, int n) {
        if (n > 0) return pow1(x, n);
        else
            return 1 / x * pow1(1 / x, -(n + 1));//One may notice that when n < 0, we cannot return myPow(1 / x, -n) because -Integer.MIN_VALUE == Integer.MIN_VALUE
    }

    public double pow1(double x, int n) {
        if (n == 1) return x;

        if (n % 2 == 0) {
            double result = myPow(x, n / 2);
            return result * result;
        } else {
            return x * myPow(x, n - 1);
        }
    }

    public static void main(String[] args) {
        Pow pow = new Pow();

        System.out.println(pow.myPow(-1, Integer.MIN_VALUE));
    }
}
