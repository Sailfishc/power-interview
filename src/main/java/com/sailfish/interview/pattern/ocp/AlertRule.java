package com.sailfish.interview.pattern.ocp;

/**
 * 通知规则
 *
 * @author sailfish
 * @create 2020-01-04-9:12 PM
 */
public class AlertRule {

    public AlertRule getMatchedRule(String api) {
        return this;
    }

    public long getMaxErrorCount() {
        return 100L;
    }


    public long getMaxTps() {
        return 1000L;
    }

    public long getMaxTimeoutTps() {
        return 0;
    }
}
