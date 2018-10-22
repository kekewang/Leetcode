package com.leetcode.easy;

/**
 * Created by wangke on 2018/10/22.
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Output: true
 Example 2:

 Input: 14
 Output: false

 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num<=1) return true;

        int left = 0, right = num;
        while (left < right) {
            int mid = (right + left) / 2;
            int powMid = mid * mid;
            if (powMid > num ) right = mid;
            else if (powMid < num) left = mid+1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(2147483647));
    }
}
