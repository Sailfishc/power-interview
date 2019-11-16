package com.sailfish.interview.dataStructure.map;

/**
 * @author sailfish
 * @create 2019-11-08-6:45 下午
 */
public class LinkedList<K, V> implements Map<K, V> {


    /**
     * 内部数据结构
     */
    private class Node {
        K key;
        V v;
        Node next;

        public Node(K key, V v, Node next) {
            this.key = key;
            this.v = v;
            this.next = next;
        }

        public Node() {
            this(null, null, null);
        }

        public Node(K key, V v) {
            this(key, v, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", v=" + v +
                    '}';
        }
    }

    private Node dummyNode;
    private int size;

    public LinkedList() {
        dummyNode = new Node();
        size = 0;
    }


    @Override
    public void add(K key, V value) {

    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void set(K key, V newValue) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 根据Key获取Node
     *
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node node = dummyNode.next;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
