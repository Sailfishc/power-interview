package com.sailfish.interview.dataStructure.heap;

import com.sailfish.interview.dataStructure.array.Array;

/**
 * @author sailfish
 * @create 2019-11-17-1:43 下午
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加元素 思路：先添加元素到最后，在进行siftUp操作
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }


    /**
     * 寻找最大元素
     *
     * @return
     */
    public E findMax() {
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        }

        return data.get(0);
    }


    /**
     * 取出堆中最大的元素
     *
     * @return
     */
    public E extractMax() {
        final E max = findMax();

        // 删除最大的元素
        /**
         * 思路：
         *  1. 将第一个元素和最后一个元素交换
         *  2. 删除最后一个元素
         *  3. 进行siftDown
         */
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return max;
    }


    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        // 循环
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            // 此时j为左右子树的较大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                // 如果当前的值已经大于子树的较大值，则终止循环
                break;
            }
            // 将k和j交换
            data.swap(k, j);
            k = j;
        }
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }


}
