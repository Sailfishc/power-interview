package com.sailfish.interview.algorithm.tree;

import java.util.Map;
import java.util.TreeMap;


/**
 * Trie树：
 *
 */
public class Trie {

    private class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }


        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }


    /**
     * 构造Trie树
     * @param word
     */
    public void add(String word) {
        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException("word is not null");
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }


}
