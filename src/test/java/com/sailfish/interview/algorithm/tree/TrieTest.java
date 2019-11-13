package com.sailfish.interview.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {


    @Test
    public void add() {
        Trie trie = new Trie();
        String s = "sailfish";
        trie.add(s);
    }
}