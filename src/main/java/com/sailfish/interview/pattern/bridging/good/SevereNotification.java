package com.sailfish.interview.pattern.bridging.good;

/**
 * @author sailfish
 * @create 2020-03-03-3:45 PM
 */
public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
