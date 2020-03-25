package com.sailfish.interview.pattern.observer.example_eventBus;

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author sailfish
 * @create 2020-03-25-4:19 PM
 */
public class UserController {

    private EventBus eventBus;

    public UserController() {
        this.eventBus = new EventBus();
    }

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
//        long userId = userService.register(telephone, password);
        long userId = 123L;

        eventBus.post(userId);

        return userId;
    }
}
