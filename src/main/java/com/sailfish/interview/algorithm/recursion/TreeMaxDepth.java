package com.sailfish.interview.algorithm.recursion;


public class TreeMaxDepth {


    public static int getTreeMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        final int left = getTreeMaxDepth(root.left);
        final int right =  getTreeMaxDepth(root.right);

        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }

    }

    public static void main(String[] args) {
//        TreeNode left3 = new TreeNode(3, null, null);
        TreeNode left1 = new TreeNode(2, null, null);
        TreeNode root = new TreeNode(1, left1, null);

        System.out.println("max Depth:" + getTreeMaxDepth(root));
    }

}
