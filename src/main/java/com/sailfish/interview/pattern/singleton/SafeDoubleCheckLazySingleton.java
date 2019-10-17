package com.sailfish.interview.pattern.singleton;

/**
 * 线程安全（懒汉式）
 * @author sailfish
 * @create 2019-10-15-18:13
 */
public class SafeDoubleCheckLazySingleton {

    private SafeDoubleCheckLazySingleton() {

    }

    private volatile static SafeDoubleCheckLazySingleton instance = null;

    public  static SafeDoubleCheckLazySingleton getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckLazySingleton.class) {
                if (instance == null) {
                    instance = new SafeDoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
