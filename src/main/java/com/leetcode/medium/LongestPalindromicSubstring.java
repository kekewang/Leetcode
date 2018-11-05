package com.leetcode.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 *
 * Created by wangke on 2018/11/5.
 */
public class LongestPalindromicSubstring {

    /**
     * incorrect answer.
     * @param s
     * @return
     */
    public String approach0(String s) {
        Boolean[][] matrix = new Boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++){
            for (int j=s.length()-1; j>=0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    matrix[i][s.length()-1-j] = true;
                } else {
                    matrix[i][s.length()-1-j] = false;
                }
            }
        }

        printMatrix(matrix);

        int maxLen = 0;
        String result = "";
        int curLen = 0;
        String curResult = "";
        int j = 0;
        int i = 0;
        for (; i<s.length(); i++, j=0) {
            int index = i;
            while (j<s.length() && index<s.length()){
                if (matrix[index][j]){
                    curResult = curResult + s.charAt(index);
                    curLen = curLen + 1;

                    if (curLen >= maxLen) {
                        result = curResult;
                        maxLen = curLen;
                    }
                }
                else {
                    curLen = 0;
                    curResult = "";
                }

                index++;
                j++;
            }

            curLen = 0;
            curResult = "";
        }

        i=0;
        curLen = 0;
        for (j=0; j<s.length(); j++, i=0) {
            int index = j;
            while (i<s.length() && index<s.length()){
                if (matrix[i][index]){
                    curResult = curResult + s.charAt(s.length()-1-index);
                    curLen = curLen + 1;

                    if (curLen >= maxLen) {
                        result = curResult;
                        maxLen = curLen;
                    }
                }
                else {
                    curLen = 0;
                    curResult = "";
                }

                i++;
                index++;
            }
            curLen = 0;
            curResult = "";
        }

        return result;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    private void printMatrix(Boolean[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                System.out.print((matrix[i][j]?1:0) + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring l = new LongestPalindromicSubstring();
        System.out.println(l.longestPalindrome("abb"));
    }
}
