package com.leetcode.medium;

/**
 * Created by wangke on 2018/11/5.
 */
public class String2Integer {
    public int myAtoi(String str) {

        int result = 0;
        for (int i=str.length()-1; i>=0; i--){
            result = str.charAt(i) - 97;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
