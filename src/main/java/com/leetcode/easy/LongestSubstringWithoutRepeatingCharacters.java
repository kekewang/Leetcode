package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 *
 * Created by wangke on 2018/3/6.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        Map<Character, Integer> charPosition = new HashMap<Character, Integer>();
        int[] preArr = new int[s.length()];
        char[] str2charArr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            Integer lastPosOfChar = charPosition.get(str2charArr[i]);
            if(lastPosOfChar == null){
                charPosition.put(str2charArr[i], i);
                preArr[i] = i == 0 ? 1 : preArr[i-1] + 1;
            }
            else {
                int aPos = lastPosOfChar + 1;
                int unRepeatLen = preArr[i-1];
                int bPos = i - unRepeatLen;
                if(aPos >= bPos){
                    preArr[i] = i - aPos + 1;
                }
                else {
                    preArr[i] = i - bPos + 1;
                }

                charPosition.put(str2charArr[i], i);
            }
        }
        int max = preArr[0];
        for(int i: preArr)
            if(i > max)
                max = i;
        return max;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        int maxLength = l.lengthOfLongestSubstring("abcaebcbb");
        System.out.println(maxLength);
    }
}
