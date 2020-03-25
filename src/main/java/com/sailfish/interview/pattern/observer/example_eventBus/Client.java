package com.sailfish.interview.pattern.observer.example_eventBus;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author sailfish
 * @create 2020-03-25-4:29 PM
 */
public class Client {


    public static void main(String[] args) {
        UserController userController = new UserController();
        List<Object> list = Lists.newArrayList(new RegNotificationObserver(), new RegPromotionObserver());
        userController.setRegObservers(list);
        userController.register("123", "123");
    }
}
