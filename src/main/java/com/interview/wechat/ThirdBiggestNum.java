package com.interview.wechat;

/**
 * 4, 在二叉排序树上面找到第3大的结点。注意：不能把二叉树全量存储到另外的存储空间
 *  比如存储在数组中，然后取出数组的第三个元素

 *
 *  TreeNode find(TreeNode root);
 */
public class ThirdBiggestNum {

    TreeNode find(TreeNode root){


        return find(root, 5);
    }

    TreeNode find(TreeNode root, int index){

        int rSize = treeSize(root.right);
        int lSize = treeSize(root.left);

        if (lSize == 0 && rSize == 0) return root;

        if (rSize >= index)
            return find(root.right, index);
        if (index - rSize - 1 > 0)
            return find(root.left, index - rSize - 1);

        return root;
    }

    int treeSize(TreeNode treeNode){
        if (treeNode == null) return 0;

        return treeSize(treeNode.left) + treeSize(treeNode.right) + 1;
    }

    public static void main(String[] args){
        ThirdBiggestNum t = new ThirdBiggestNum();
        TreeNode node1 = new TreeNode(1,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node8 = new TreeNode(8,null,null);
        TreeNode node4 = new TreeNode(4,node3,null);
        TreeNode node2 = new TreeNode(2,node1,node4);
        TreeNode node7 = new TreeNode(7,node6,node8);
        TreeNode node5 = new TreeNode(5,node2,node7);

        TreeNode result = t.find(node5);

        for (int i = 1; i <= t.treeSize(node5); i++) {
            System.out.println("第" + i + "大的数字为" + t.find(node5, i).value);
        }
    }

    void printTree(TreeNode treeNode){
        System.out.println(treeNode.value);

        if (treeNode.left!=null)
            printTree(treeNode.left);

        if (treeNode.right!=null)
            printTree(treeNode.right);
    }
}
