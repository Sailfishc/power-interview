package com.sailfish.interview.algorithm.tree;

import com.sailfish.interview.util.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {


    @Test
    public void add() {
        Trie trie = new Trie();
        String s = "sailfish";
        trie.add(s);

        String s1 = "sailfishcc";
        trie.add(s1);
    }


    @Test
    public void testCountTrie() {
        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);

        final long start = System.currentTimeMillis();
        Trie trie = new Trie();
        for (String s : list) {
            trie.add(s);
        }
        System.out.println("add word spend time:" + (System.currentTimeMillis() - start) + "millis");
        System.out.println("trie size:" + trie.getSize());
    }
}