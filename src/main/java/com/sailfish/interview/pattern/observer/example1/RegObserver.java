package com.sailfish.interview.pattern.observer.example1;

/**
 * @author sailfish
 * @create 2020-03-25-4:17 PM
 */
public interface RegObserver {

    /**
     * 执行注册成功之后处理的事情
     *
     * @param userId
     */
    void handleRegSuccess(long userId);
}
