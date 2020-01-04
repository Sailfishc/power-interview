package com.sailfish.interview.pattern.ocp.good;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sailfish
 * @create 2020-01-04-9:27 PM
 */
public class Alert {

    private List<AlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }

}
