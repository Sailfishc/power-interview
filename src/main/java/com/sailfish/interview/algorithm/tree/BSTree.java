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
     * 前序遍历
     *
     * @return
     */
    public void preTraverse() {

        preTraverse(root);
    }


    /**
     * 中序遍历
     */
    public void middleTraverse() {
        middleTraverse(root);
    }


    /**
     * 后续遍历
     */
    public void afterTraverse() {
        afterTraverse(root);
    }


    /**
     * 查询最小的节点
     * 规则：左子树的的下一个节点为NULL为最小节点
     *
     * @return
     */
    public E findMinNode() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        final Node minNode = findMinNode(root);
        return minNode.e;
    }


    /**
     * 查询最小的节点
     * 规则：左子树的的下一个节点为NULL为最小节点
     *
     * @return
     */
    public E findMaxNode() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        final Node maxNode = findMaxNode(root);
        return maxNode.e;
    }

    private Node findMaxNode(Node node) {
        if (node.right == null) {
            return node;
        }
        return findMaxNode(node.right);
    }

    private Node findMinNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMinNode(node.left);
    }


    private void afterTraverse(Node node) {
        if (node == null) {
            return;
        }

        afterTraverse(node.left);
        afterTraverse(node.right);
        System.out.println(node.e);
    }

    private void middleTraverse(Node node) {
        if (node == null) {
            return;
        }
        middleTraverse(node.left);
        System.out.println(node.e);
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
        generateString(root, 0, sb);
        return sb.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++){
            res.append("--");
        }

        return res.toString();
    }
}
