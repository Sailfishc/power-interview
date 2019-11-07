package com.sailfish.interview.algorithm.tree;

/**
 * 二分搜索树
 *
 * @author sailfish
 * @create 2019-11-07-4:19 下午
 */
public class BSTree<E extends Comparable<E>> {


    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTree() {
        root = null;
        size = 0;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }


    /**
     * 优化版本：
     *      1. 去除对于root的特殊处理
     *      2. 简化递归的终止条件
     * @param e
     */
    public void addNode(E e) {
        root = addNode(root, e);
    }


    /**
     * 查找二叉树元素
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }


    /**
     * 中序遍历
     *
     * @return
     */
    public void preTraverse() {

        preTraverse(root);
    }


    public void middleTraverse() {
        middleTraverse(root);
    }


    private void middleTraverse(Node node) {
        if (root == null) {
            return;
        }
        middleTraverse(node.left);
        System.out.println(node);
        middleTraverse(node.right);
    }

    private void preTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preTraverse(node.left);
        preTraverse(node.right);
    }





    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    // 理论支持：NULL也可以当做链表
    private Node addNode(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = addNode(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addNode(node.right, e);
        }

        return node;
    }



    // 递归添加
    private void add(Node node, E e) {
        // 终止条件
        if (e.compareTo(node.e) == 0) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            Node value = new Node(e);
            node.left = value;
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            Node value = new Node(e);
            node.right = value;
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateSBTString(root, 1, sb);
        return sb.toString();
    }

    private void generateSBTString(Node node, int depth, StringBuilder sb) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        sb.append(node.e);

        generateSBTString(node.left, depth++, sb);
        generateSBTString(node.right, depth++, sb);

    }
}
