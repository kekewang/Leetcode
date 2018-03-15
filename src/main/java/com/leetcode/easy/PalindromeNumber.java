package com.leetcode.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p>
 * Created by wangke on 2018/3/14.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
    public static void main(String[] args) {

        PalindromeNumber r = new PalindromeNumber();

        System.out.println(r.isPalindrome(3215123));
    }
}
