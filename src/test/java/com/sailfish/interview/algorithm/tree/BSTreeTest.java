package com.sailfish.interview.algorithm.tree;

import com.sailfish.interview.algorithm.sort.ArrayGenHelper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sailfish
 * @create 2019-11-07-5:18 下午
 */
public class BSTreeTest {

    @Test
    public void add() {
        BSTree<Integer> tree = new BSTree<>();

        final Integer[] arr = ArrayGenHelper.generateRandomArr(10, 1, 20);
        ArrayGenHelper.printArray(arr);

        for (Integer num : arr) {
            tree.add(num);
        }
        System.out.println(tree.size());
    }


    @Test
    public void addNode() {
        BSTree<Integer> tree = assemblyTree();
        System.out.println(tree.size());
    }

    private BSTree<Integer> assemblyTree() {
        BSTree<Integer> tree = new BSTree<>();

        final Integer[] arr = ArrayGenHelper.generateRandomArr(3, 1, 20);
        ArrayGenHelper.printArray(arr);

        for (Integer num : arr) {
            tree.addNode(num);
        }
        return tree;
    }


    @Test
    public void containNode() {
        BSTree<Integer> tree = assemblyTree();
        System.out.println(tree.contains(300));

        tree.add(3);
        System.out.println(tree.contains(3));
    }


    @Test
    public void middleTraverse() {
        BSTree<Integer> tree = assemblyTree();

        tree.middleTraverse();
    }


    @Test
    public void testToString() {
        BSTree<Integer> tree = assemblyTree();
        System.out.println(tree.toString());
    }
}