package com.sailfish.interview.dataStructure.heap;

import org.junit.Test;

/**
 * @author sailfish
 * @create 2019-11-17-2:04 下午
 */
public class MaxHeapTest {

    @Test
    public void add() {
    }

    @Test
    public void findMax() {
        MaxHeap<Integer> heap = new MaxHeap<>();

        for (int i = 0; i < 1000; i++) {
            heap.add(i);
        }

        System.out.println("max element: " + heap.findMax());
    }


    @Test
    public void removeMax() {
        MaxHeap<Integer> heap = new MaxHeap<>();

        for (int i = 0; i < 1000; i++) {
            heap.add(i);
        }

        for (int i = 0; i < 100; i++) {
//            System.out.println("heap max value: " + heap.findMax());
            System.out.println("remove max value: " + heap.extractMax());
        }
    }
}