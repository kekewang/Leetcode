package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangke on 2018/3/23.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";

        if (strs.length==1)
            return strs[0];

        String str1 = commonPrefix(strs[0], strs[1]);
        for (int i=1; i<strs.length; i++){
            str1 = commonPrefix(str1, strs[i]);
        }

        return str1;
    }
    public String commonPrefix(String str1, String str2){
        int commonIndex = 0;
        for (int i=0, j=0; i<str1.length() && j<str2.length();i++, j++){
            if (str1.charAt(i) == str2.charAt(j))
                commonIndex ++;
            else
                break;
        }
        return str1.substring(0, commonIndex);
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"abc", "abcde", "ab"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
