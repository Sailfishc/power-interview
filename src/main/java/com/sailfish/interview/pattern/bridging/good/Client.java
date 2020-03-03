package com.sailfish.interview.pattern.bridging.good;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sailfish
 * @create 2020-03-03-3:51 PM
 */
public class Client {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1898888");
        Notification notification = new NormalNotification(new TelephoneMsgSender(list));
        notification.notify("Hello");
    }
}
