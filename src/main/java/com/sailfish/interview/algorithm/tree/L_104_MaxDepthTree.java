package com.sailfish.interview.algorithm.tree;


import com.sailfish.interview.algorithm.sort.ArrayGenHelper;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author sailfish
 * @create 2019-11-07-2:02 下午
 */
public class L_104_MaxDepthTree {

    static class Solution {
        public int maxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }

            final int leftDepth = maxDepth(node.left);
            final int rightDepth = maxDepth(node.right);

            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        final Integer[] arr = ArrayGenHelper.generateRandomArr(3, 1, 50);

        TreeNode treeNode = genTreeNode(arr);

        final int depth = solution.maxDepth(treeNode);
        System.out.println(depth);

//        while (treeNode.left != null || treeNode.right != null) {
//            if (treeNode.left != null) {
//                System.out.println(treeNode.val);
//                treeNode = treeNode.left;
//            } else {
//                System.out.println(treeNode.val);
//                treeNode = treeNode.right;
//            }
//        }
    }

    private static TreeNode genTreeNode(Integer[] arr) {
        TreeNode root = new TreeNode(0);
        TreeNode subRoot = root;
        boolean open = true;
        for (Integer num : arr) {
            if (open) {
                TreeNode left = new TreeNode(num);
                subRoot.left = left;
                subRoot = left;
            } else {
                TreeNode right = new TreeNode(num);
                subRoot.right = right;
                subRoot = right;
            }
            open = !open;
        }
        return root;
    }
}
