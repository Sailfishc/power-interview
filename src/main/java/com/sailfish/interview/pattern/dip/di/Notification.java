package com.sailfish.interview.pattern.dip.di;

/**
 * @author sailfish
 * @create 2020-01-04-10:44 PM
 */
public class Notification {

    private MessageSender messageSender;

    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }


    public void sendMessage(String cellphone, String message) {
        this.messageSender.send(cellphone, message);
    }
}
