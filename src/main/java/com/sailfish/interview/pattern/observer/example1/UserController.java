package com.sailfish.interview.pattern.observer.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sailfish
 * @create 2020-03-25-4:19 PM
 */
public class UserController {

    private List<RegObserver> regObservers = new ArrayList<>();

    // 一次性设置好，之后也不可能动态的修改
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) { //省略输入参数的校验代码 //省略userService.register()异常的try-catch代码
//        long userId = userService.register(telephone, password);
        long userId = 123L;
        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }
}
