package com.sailfish.interview.concurrent.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 通过Stamp来解决ABA问题
 *
 * @author sailfish
 * @create 2019-10-20-10:48
 */
public class AtomicStampReferenceDemo {

    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(0, 0);


    public static void main(String[] args) {
        stampedReference.compareAndSet(0, 1, 0, 5);
        System.out.println("stamp=" + stampedReference.getStamp());
        System.out.println("reference value = " + stampedReference.getReference());
    }
}
