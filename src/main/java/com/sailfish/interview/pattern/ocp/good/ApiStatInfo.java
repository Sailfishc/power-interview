package com.sailfish.interview.pattern.ocp.good;

import lombok.Data;

/**
 * @author sailfish
 * @create 2020-01-04-9:27 PM
 */
@Data
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long durationOfSeconds;
}
