package com.sailfish.interview.pattern.singleton;

/**
 * 线程安全（懒汉式）
 * @author sailfish
 * @create 2019-10-15-18:13
 */
public class SafeLazySingleton {

    private SafeLazySingleton() {

    }

    private static SafeLazySingleton instance = null;

    public synchronized static SafeLazySingleton getInstance() {
        if (instance == null) {
            instance = new SafeLazySingleton();
        }
        return instance;
    }
}
