package com;


class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class SearchTree {

    int thirdMax(TreeNode treeNode, int nth){
        if (treeNode == null)
            return 0;

        int left = 0, right = 0;
        if (treeNode.right != null){
            right = thirdMax(treeNode.right, nth);
        }

        if (right + 1 == nth){
            System.out.println(treeNode.value);
        }

        if (treeNode.left != null){
            left = thirdMax(treeNode.left, nth - right - 1);
        }

        if (left < nth - right - 1)
            return left + right + 1;

        return 1;
    }

    public static void main(String[] args){
        TreeNode treeNode9 = new TreeNode(9, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode8 = new TreeNode(8, null, null);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        treeNode7.left = treeNode6;
        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode5;
        treeNode2.left = treeNode1;

        SearchTree searchTree = new SearchTree();
        searchTree.thirdMax(treeNode3, 3);
    }
}
