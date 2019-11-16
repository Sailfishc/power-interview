package com.sailfish.interview.dataStructure.map;

/**
 * Map接口
 * @author sailfish
 * @create 2019-11-08-6:45 下午
 */
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}