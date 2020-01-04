package com.sailfish.interview.pattern.ocp.bad;

import com.sailfish.interview.pattern.ocp.AlertRule;
import com.sailfish.interview.pattern.ocp.Notification;
import com.sailfish.interview.pattern.ocp.NotificationEmergencyLevel;

/**
 * @author sailfish
 * @create 2020-01-04-9:11 PM
 */
public class Alert {

    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorCount, long durationSecond) {
        long tps = requestCount / durationSecond;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
