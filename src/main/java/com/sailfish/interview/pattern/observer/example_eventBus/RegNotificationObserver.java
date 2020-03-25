package com.sailfish.interview.pattern.observer.example_eventBus;

import com.google.common.eventbus.Subscribe;

/**
 * @author sailfish
 * @create 2020-03-25-4:19 PM
 */
public class RegNotificationObserver {

    @Subscribe
    public void doHandler(long userId) {
        // do something like notice user
        // ....
        System.out.println("RegNotificationObserver handleRegSuccess " + userId);
    }
}
