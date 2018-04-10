package com.leetcode.medium;

import com.leetcode.easy.AddTwoNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {



    private char[][] nodes = new char[10][];
    private void initTree(){
        nodes[0] = new char[]{};
        nodes[1] = new char[]{};
        nodes[2] = new char[]{'a','b','c'};
        nodes[3] = new char[]{'d','e','f'};
        nodes[4] = new char[]{'g','h','i'};
        nodes[5] = new char[]{'j','k','l'};
        nodes[6] = new char[]{'m','n','o'};
        nodes[7] = new char[]{'p','q','r','s'};
        nodes[8] = new char[]{'t','u','v'};
        nodes[9] = new char[]{'w','x','y','z'};
    }
    public List<String> letterCombinations(String digits) {
        ArrayList arrayList = new ArrayList();
        if (digits==null || digits.length() == 0)
            return arrayList;

        initTree();
        letterCombination(digits, 0, arrayList, "");
        return arrayList;
    }

    private void letterCombination(String digits, int index, List<String> result, String str){
        if (index==digits.length()){
            result.add(str);
            return;
        }
        int num = Character.digit(digits.charAt(index), 10);
        for (int i = 0; i<nodes[num].length; i++){
            String currentStr = str;
            currentStr += nodes[num][i];
            letterCombination(digits, index+1, result, currentStr);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
        System.out.println(l.letterCombinations(""));
    }
}
