package com.sailfish.interview.pattern.bridging.good;

/**
 * @author sailfish
 * @create 2020-03-03-3:45 PM
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }


    public abstract void notify(String message);
}
