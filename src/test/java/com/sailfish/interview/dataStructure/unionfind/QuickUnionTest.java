package com.sailfish.interview.dataStructure.unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sailfish
 * @create 2019-11-16-4:34 下午
 */
public class QuickUnionTest {

    private static final int n = 1000;
    QuickUnion quickUnion = new QuickUnion(n);


    @Test
    public void getSize() {
        System.out.println(quickUnion.getSize());
    }

    @Test
    public void isConnected() {
        System.out.println(quickUnion.isConnected(1, 100));
    }

    @Test
    public void unionElements() {
        System.out.println(quickUnion.isConnected(1, 100));

        quickUnion.unionElements(1, 100);

        System.out.println(quickUnion.isConnected(1, 100));

    }
}