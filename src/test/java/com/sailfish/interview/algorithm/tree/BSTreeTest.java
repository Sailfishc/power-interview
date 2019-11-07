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
}