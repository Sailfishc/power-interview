package com.sailfish.interview.pattern.singleton;

/**
 * 饿汉式（线程安全）
 * @author sailfish
 * @create 2019-10-15-18:12
 */
public class EarlySingleton {

    private EarlySingleton() {

    }

    private static EarlySingleton instance = new EarlySingleton();

    public static EarlySingleton getInstance() {
        return instance;
    }
}
