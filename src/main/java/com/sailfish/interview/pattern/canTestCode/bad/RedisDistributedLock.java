package com.sailfish.interview.pattern.canTestCode.bad;

/**
 * 一个工具组件，这里创建只是为了避免编译错误（一般是二方包）
 *
 * @author sailfish
 * @create 2020-01-14-6:46 PM
 */
public class RedisDistributedLock {


    public static RedisDistributedLock getSingletonInstance() {
        return null;
    }


    public boolean lockTransaction(String id) {
        return false;
    }

    public void unlockTransaction(String id) {

    }
}
