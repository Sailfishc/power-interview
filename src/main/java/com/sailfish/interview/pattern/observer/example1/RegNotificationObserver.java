package com.sailfish.interview.pattern.observer.example1;

/**
 * @author sailfish
 * @create 2020-03-25-4:19 PM
 */
public class RegNotificationObserver implements RegObserver {

    @Override
    public void handleRegSuccess(long userId) {
        // do something like notice user
        // ....
    }
}
