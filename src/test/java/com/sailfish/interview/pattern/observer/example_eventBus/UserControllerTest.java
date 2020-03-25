package com.sailfish.interview.pattern.observer.example_eventBus;

import com.google.common.eventbus.EventBus;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sailfish
 * @create 2020-03-25-5:47 PM
 */
public class UserControllerTest {

    @Test
    public void register() {
        EventBus bus = new EventBus();
        bus.register(new RegNotificationObserver());

        bus.post("userId");
    }


}