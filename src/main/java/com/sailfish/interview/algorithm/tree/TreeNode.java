package com.sailfish.interview.algorithm.tree;

/**
 * @author sailfish
 * @create 2019-11-07-2:03 下午
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


}
