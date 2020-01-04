package com.sailfish.interview.pattern.ocp.good;

import com.sailfish.interview.pattern.ocp.AlertRule;
import com.sailfish.interview.pattern.ocp.Notification;

/**
 * @author sailfish
 * @create 2020-01-04-9:27 PM
 */
public abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }


    public abstract void check(ApiStatInfo apiStatInfo);
}
