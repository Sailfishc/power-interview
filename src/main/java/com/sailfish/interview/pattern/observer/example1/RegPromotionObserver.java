package com.sailfish.interview.pattern.observer.example1;

/**
 * @author sailfish
 * @create 2020-03-25-4:18 PM
 */
public class RegPromotionObserver implements RegObserver {

    @Override
    public void handleRegSuccess(long userId) {
        // do something like give promotion coupon
        // ....
    }
}
