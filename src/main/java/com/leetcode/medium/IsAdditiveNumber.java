package com.leetcode.medium;

/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 *
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3)return false;
        long ppre = 0, pre = 0;
        //找出第一个数和第二个数
        for (int i = 1; i <= n / 2; ++i) {//第一个数的长度不能超过n/2
            String s1 = num.substring(0, i);
            if (s1.length() > 1 && s1.startsWith("0"))
                break;
            ppre = Long.parseLong(s1);
            for (int j = 1; i + j <= (n * 2) / 3; ++j) {//第一个和第二个数总的长度不能超过2/3
                String s2 = num.substring(i, i+j);
                if (s2.length() > 1 && s2.startsWith("0"))
                    break;
                pre = Long.parseLong(s2);//从位置i开始截取
                if (dfs(i + j, Math.max(i, j), pre, ppre, num))return true;//第二个数不一定比第一个数大
            }
        }
        return false;
    }

    /**
     * 计算当前的数是不是前两个数的和
     * pos代表当前指针达到的位置
     * len代表要截取的长度
     * pre代表前面的数
     * ppre代表前一个的前一个数
     * s代表字符串
     */
    private boolean dfs(int pos, int len, long pre, long ppre, String s) {
        int n = s.length();
        if (pos == n)return true;//已经计算到最后了
        boolean flag = false;
        long cur = 0;
        for (int i = len; pos + i <= n; ++i) {
            String s3 = s.substring(pos, pos+i);
            if (s3.length() > 1 && s3.startsWith("0"))
                break;
            cur = Long.parseLong(s3);
            if (cur > pre + ppre)break;//当前的数大于两者之和，就跳出循环，不能再截取更长的长度了
            if (cur < pre + ppre)continue;//如果当前的数小于两者之和，就截取更长的一位
            flag = dfs(pos + i, i, cur, pre, s);//对当前来说两者相等，继续检验，下一次的开始长度至少和前面一个一样
            if (flag)break;//只要找到一个，就可以跳出了
        }
        return flag;
    }

    public static void main(String[] args) {
        IsAdditiveNumber isAdditiveNumber = new IsAdditiveNumber();
        boolean ret = isAdditiveNumber.isAdditiveNumber("000");
    }
}
