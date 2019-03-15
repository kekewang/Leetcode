package com.leetcode.easy;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        int temp = 0;

        if (haystack.contains(needle)) {

            for (int i = 0; i < haystack.length(); i++) {

                int j = 0;
                temp = i;
                while (haystack.charAt(temp) == needle.charAt(j)) {
                    if (j + 1 == needle.length()) {
                        return temp - (needle.length() - 1);
                    } else {
                        j++;
                        temp++;
                    }


                }

            }
            return -1;

        } else {
            return -1;
        }
    }
}
