package com.sailfish.interview.pattern.canTestCode.good.step2;

import com.sailfish.interview.pattern.canTestCode.bad.RedisDistributedLock;

/**
 * RedisDistributedLock 是一个单例类。单例相当于一个全局变量，我们无法 mock(无法继承和重写方法)，也无法通过依赖注入的方式来替换。
 * 所以将RedisDistributedLock抽离出来，作为一个Bean
 *
 * @author sailfish
 * @create 2020-01-15-10:11 AM
 */
public class TransactionLock {

    /**
     * Lock
     *
     * @param id
     * @return
     */
    public boolean lock(String id) {
        return RedisDistributedLock.getSingletonInstance().lockTransaction(id);
    }


    public void unLock(String id) {
        RedisDistributedLock.getSingletonInstance().unlockTransaction(id);
    }

}
