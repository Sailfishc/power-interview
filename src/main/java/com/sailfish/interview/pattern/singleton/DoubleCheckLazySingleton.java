package com.sailfish.interview.pattern.singleton;

/**
 * 线程不安全（懒汉式）
 * @author sailfish
 * @create 2019-10-15-18:13
 */
public class DoubleCheckLazySingleton {

    private DoubleCheckLazySingleton() {

    }

    private static DoubleCheckLazySingleton instance = null;

    public  static DoubleCheckLazySingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
