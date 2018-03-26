package com.leetcode.easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * Created by wangke on 2018/3/26.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int len = 2 * (numRows - 1);
        String result = "";
        if (len == 0 || numRows == 0 || numRows == 1)//特殊情况特殊处理
            return s;
        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += len) {
                result += s.charAt(j);//第一行和最后一行 还有普通行的整列数字
                if (row != 0 && row != numRows - 1 && j - 2 * row + len < s.length())
                    result += s.charAt(j - 2 * row + len);//单列行的数字
            }
        }
        return result;
    }

    /**
     *  模拟字符被放入每个位置的流程
     * @param s
     * @param nRows
     * @return
     */
    public String convert1(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zigZagConversion = new ZigZagConversion();
        System.out.print(zigZagConversion.convert("PAYPALISHIRING", 5));
    }
}