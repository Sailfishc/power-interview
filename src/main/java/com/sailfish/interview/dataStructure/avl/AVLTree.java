package com.sailfish.interview.dataStructure.avl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 平衡二分搜索树
 *
 * @author sailfish
 * @create 2019-11-07-4:19 下午
 */
public class AVLTree<E extends Comparable<E>> {


    private class Node {
        public E e;
        public Node left, right;
        public int height;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            height = 1;
        }


    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    /**
     * 获取高度
     *
     * @param node
     * @return
     */
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }


    /**
     * 获取平衡因子
     *
     * @param node
     * @return
     */
    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.left) - getHeight(node.right);
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
     * 是否是一个二分查找树
     *
     * @param node
     * @return
     */
    public boolean isBST() {

        List<E> list = new ArrayList<>();

        inOrder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(list.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }


    // 左右子树的平衡因子小于1
    public boolean isBalance() {

        return isBalance(root);
    }

    private boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }
        final int balanceFactory = getBalanceFactor(node);
        if (Math.abs(balanceFactory) > 1) {
            return false;
        }
        return isBalance(node.left) && isBalance(node.right);
    }


    private void inOrder(Node node, List<E> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.e);
        inOrder(node.right, list);
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

    /**
     * 层级遍历
     *
     */
    public void levelTraverse() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            // 对Node的操作
            System.out.println(cur.e);

            if (cur.left != null) {
                q.add(cur.left);
            }

            if (cur.right != null){
                q.add(cur.right);
            }
        }
    }


    /**
     * 删除最小节点
     *
     * @return
     */
    public E removeMin() {
        final E min = findMinNode();
        removeMin(root);
        return min;
    }


    /**
     * 1. 查找最小节点
     * 2. 最小节点右子节点为空，直接删除
     * 3. 最小节点右子节点不为空，将右子节点设置为当前节点
     * @param node
     * @return
     */
    private Node  removeMin(Node node) {

        // 终止条件
        if (node.left == null) {
            final Node rightNode = node.right;
            size--;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 删除最大节点
     *
     * @return
     */
    public E removeMax() {
        final E max = findMaxNode();
        removeMax(root);
        return max;
    }


    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        Node retNode;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            // return node;
            retNode = node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            // return node;
            retNode = node;
        } else {   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                // return rightNode;
                retNode = rightNode;
            }

            // 待删除节点右子树为空的情况
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                // return leftNode;
                retNode = leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            else {
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = findMinNode(node.right);
                //successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.e);
                successor.left = node.left;

                node.left = node.right = null;

                // return successor;
                retNode = successor;
            }
        }
        if (retNode == null) {
            return null;
        }

        // 进行翻转操作（AVL）
        return flipNode(retNode);
    }

    /**
     * @param node
     * @return
     */
    private Node  removeMax(Node node) {

        // 终止条件
        if (node.right == null) {
            final Node leftNode = node.left;
            size--;
            node.left = null;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
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
        } else {
            node.e = e;
        }
       return flipNode(node);
    }

    private Node flipNode(Node node) {
        // 添加完Node后需要维护Height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        final int balanceFactory = getBalanceFactor(node);

//        if (Math.abs(balanceFactory) > 1) {
//            // 要进行翻转，保持平衡
//            System.out.println("tree balance Factory:  " + balanceFactory);
//        }

        // 对搜索树进行翻转操作
        // LL RR LR RL 四种操作
        if (balanceFactory > 1 && getBalanceFactor(node.left) >= 0) {
            // LL场景
            return rightFlip(node);
        }

        if (balanceFactory < -1 && getBalanceFactor(node.right) <= 0) {
            // RR
            return leftFlip(node);
        }

        if (balanceFactory > 1 && getBalanceFactor(node.left) < 0) {
            // LR场景
            node.left = leftFlip(node.left);
            return rightFlip(node);
        }

        if (balanceFactory < -1 && getBalanceFactor(node.right) > 0) {
            // RL
            node.right = rightFlip(node.right);
            return leftFlip(node);
        }

        return node;
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightFlip(Node y) {

        final Node x = y.left;
        final Node T3 = x.right;

        x.right = y;
        y.left = T3;

        // 计算高度
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }



    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftFlip(Node y) {

        final Node x = y.right;
        final Node T2 = x.left;

        x.left = y;
        y.right = T2;

        // 计算高度
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
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
