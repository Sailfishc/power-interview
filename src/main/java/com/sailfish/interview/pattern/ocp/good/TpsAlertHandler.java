package com.sailfish.interview.pattern.ocp.good;

import com.sailfish.interview.pattern.ocp.AlertRule;
import com.sailfish.interview.pattern.ocp.Notification;
import com.sailfish.interview.pattern.ocp.NotificationEmergencyLevel;

/**
 * @author sailfish
 * @create 2020-01-04-9:29 PM
 */
public class TpsAlertHandler extends AlertHandler {


    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
