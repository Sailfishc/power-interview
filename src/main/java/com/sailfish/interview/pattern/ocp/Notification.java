package com.sailfish.interview.pattern.ocp;

/**
 * @author sailfish
 * @create 2020-01-04-9:12 PM
 */
public interface Notification {

    /**
     * 通知消息
     * @param level
     * @param message
     * @return
     */
    boolean notify(NotificationEmergencyLevel level, String message);
}
