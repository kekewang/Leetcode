package com.leetcode.easy;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * I - 1
 * V - 5
 * X - 10
 * L - 50
 * C - 100
 * D - 500
 * M - 1000
 * <p>
 * Created by wangke on 2018/3/20.
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'M') {
                result += 1000;
            } else if (ch == 'D') {
                result += 500;
            } else if (ch == 'C') {
                result += 100;
            } else if (ch == 'L') {
                result += 50;
            } else if (ch == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) != 'X') {
                    result -= 10;
                } else {
                    result += 10;
                }
            } else if (ch == 'V') {
                result += 5;
            } else if (ch == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) != 'I') {
                    result -= 1;
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomantoInteger romantoInteger = new RomantoInteger();
        System.out.println(romantoInteger.romanToInt("MCMXCVI"));
    }
}
