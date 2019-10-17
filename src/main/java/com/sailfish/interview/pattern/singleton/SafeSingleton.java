package com.sailfish.interview.pattern.singleton;

/**
 * 线程安全的单例模式
 *
 * @author sailfish
 * @create 2019-10-15-18:08
 */
public class SafeSingleton {


    private SafeSingleton() {

    }

    private static class Holder {

        public static final SafeSingleton instance = new SafeSingleton();
    }

    public static SafeSingleton getInstance() {
        return Holder.instance;
    }
}
