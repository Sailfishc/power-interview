package com.sailfish.interview.pattern.bridging.good;

import java.util.List;

/**
 * @author sailfish
 * @create 2020-03-03-3:44 PM
 */
public class TelephoneMsgSender implements MsgSender {

    private List<String> telephone;

    public TelephoneMsgSender(List<String> telephone) {
        this.telephone = telephone;
    }

    @Override
    public void send(String message) {
        // send message
        System.out.println("Telephone Send: " + message);
    }
}
