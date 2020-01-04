package com.sailfish.interview.pattern.ocp.good;

import com.sailfish.interview.pattern.ocp.AlertRule;
import com.sailfish.interview.pattern.ocp.Notification;
import com.sailfish.interview.pattern.ocp.NotificationEmergencyLevel;

/**
 * @author sailfish
 * @create 2020-01-04-9:29 PM
 */
public class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long errorCount = apiStatInfo.getErrorCount() / apiStatInfo.getDurationOfSeconds();
        if (errorCount > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
