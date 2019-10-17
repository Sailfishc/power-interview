package com.sailfish.interview.javabase;

import java.math.BigDecimal;

/**
 * 对比BigDecimal的一些常用方法
 * @author sailfish
 * @create 2019-10-16-10:07
 */
public class BigDecimalDemo {


    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.00");
        BigDecimal b = new BigDecimal("0");

        System.out.println(a.equals(b));
        System.out.println(a.compareTo(b));

    }
}
