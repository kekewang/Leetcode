package com.leetcode.medium;

/**
 * Created by wangke on 2018/11/5.
 */
public class String2Integer {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        long res = 0;
        int sign = 1;
        int begin = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                begin = i;
                break;
            }

        }
        if (str.charAt(begin) == '-') {
            sign = -1;
            begin++;
        } else if (str.charAt(begin) >= '0' && str.charAt(begin) <= '9') {
            sign = 1;
        } else if (str.charAt(begin) == '+') {
            sign = 1;
            begin++;
        } else {
            return 0;
        }

        for (int i = begin; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                res = res * 10 + (int) (ch - '0');
                if (sign * res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if (sign * res < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            } else {
                break;
            }

        }
        res = sign * res;
        return (int) res;
    }

    public int myAtoi0(String str) {
        if (str == null || (str.replace(" ", "").isEmpty()))
            return 0;

        str = str.replace(" ", "");
        int result = 0;
        boolean isNegative = false;
        if (str.charAt(0) == '-') {
            isNegative = true;
            str = str.substring(1, str.length());
        }
        if (!str.isEmpty() && str.charAt(0) == '+') {
            isNegative = false;
            str = str.substring(1, str.length());
        }
        if (str.isEmpty() || (str.charAt(0) < 48 || str.charAt(0) > 57)) {
            return 0;
        }
        int numCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                result = (str.charAt(i) - 48) * (int) Math.pow(10, numCount++) + result;
            }

            if (str.charAt(i) == '.') {
                result = 0;
                numCount = 0;
            }
        }
        if (result < 0) {
            return Integer.MIN_VALUE;
        }
        return isNegative ? -1 * result : result;
    }

    public static void main(String[] args) {
        String2Integer s = new String2Integer();
        System.out.println(s.myAtoi("-+1"));
    }
}
