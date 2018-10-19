package com.interview.wechat;

/*
 * 2, 有一个二叉树，每个节点的值是一个整数，写一个函数，判断这棵树中是否存在从根到叶子
 *  结点的一个路径，这个路径上所有节点之和为某一个值，存在返回1，否则返回0
 * class TreeNode {
 *   int value;
 *   TreeNode left, right;
 *  }
 *
 *  int haspath(TreeNode root, int value);
 */

class TreeNode {
    int value;
    TreeNode left, right;
}

public class TreePath {
    int haspath(TreeNode root, int value) {

        if (root.left != null)
            return haspath(root.left, value - root.value);

        if (root.right != null)
            return haspath(root.right, value - root.value);
        return value == 0 ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
