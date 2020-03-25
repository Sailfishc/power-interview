package com.sailfish.interview.pattern.observer.example_eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author sailfish
 * @create 2020-03-25-4:18 PM
 */
public class RegPromotionObserver {

    @Subscribe
    public void handleRegSuccess(long userId) {
        // do something like give promotion coupon
        // ....
        System.out.println("RegPromotionObserver handleRegSuccess " + userId);

    }
}
