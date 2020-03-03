package com.sailfish.interview.pattern.bridging.good;

/**
 * @author sailfish
 * @create 2020-03-03-3:45 PM
 */
public class TrivialNotification extends Notification {

    public TrivialNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
