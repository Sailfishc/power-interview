package com.sailfish.interview.pattern.ocp.bad;

import com.sailfish.interview.pattern.ocp.AlertRule;
import com.sailfish.interview.pattern.ocp.Notification;
import com.sailfish.interview.pattern.ocp.NotificationEmergencyLevel;

/**
 * @author sailfish
 * @create 2020-01-04-9:11 PM
 */
public class Alert2 {

    private AlertRule rule;
    private Notification notification;

    public Alert2(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public void check(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }

        // 改动二：
        long timeoutTps = timeoutCount / durationOfSeconds;
        if (timeoutTps > rule.getMatchedRule(api).getMaxTimeoutTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
