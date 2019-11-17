package com.sailfish.interview.dataStructure.array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sailfish
 * @create 2019-11-17-1:32 下午
 */
public class ArrayTest {

    @Test
    public void addLast() {

        Array<Integer> array = new Array<>();

        for (int i = 0; i < 10000; i++) {
            array.addLast(i);
        }

//        System.out.println(array);

        array.remove(100);

        System.out.println("array size:" + array.getSize());
        System.out.println("get Remove Ele:" + array.get(100));

        array.removeElement(1000);
    }
}