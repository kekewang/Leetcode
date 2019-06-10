package com.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char temp : s.toCharArray()) {
            if (temp == '(' || temp == '{' || temp == '[')
                stack.push(temp);
            else {
                if (stack.isEmpty())
                    return false;
                char last = stack.pop();
                if ((temp == ')' && last != '(') || (temp == '}' && last != '{') || (temp == ']' && last != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(args.toString());
    }
}
