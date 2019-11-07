package com.sailfish.interview.algorithm.tree;

import java.util.Comparator;

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
}
