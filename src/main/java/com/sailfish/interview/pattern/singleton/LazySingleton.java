package com.sailfish.interview.pattern.singleton;

/**
 * 线程不安全（懒汉式）
 * @author sailfish
 * @create 2019-10-15-18:13
 */
public class LazySingleton {

    private LazySingleton() {

    }

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
