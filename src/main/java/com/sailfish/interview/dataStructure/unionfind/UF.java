package com.sailfish.interview.dataStructure.unionfind;

/**
 * @author sailfish
 * @create 2019-11-16-4:18 下午
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
