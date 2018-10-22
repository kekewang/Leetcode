package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List result = new ArrayList();
        generate(n, n, "", result);
        return result;
    }

    public void generate(int left, int right, String parentheses, List result){
        if (left < 0 || right < 0 || left > right) return;

        if (left == 0 && right == 0) {
            result.add(parentheses);
            return;
        }

        if (left > 0)
            generate(left-1, right, parentheses + "(", result);

        if (right > 0)
            generate(left, right-1, parentheses + ")", result);
    }

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        System.out.println(g.generateParenthesis(3));
    }
}
