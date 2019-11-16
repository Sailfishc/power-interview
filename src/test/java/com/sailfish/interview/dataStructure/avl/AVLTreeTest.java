package com.sailfish.interview.dataStructure.avl;

import com.sailfish.interview.util.FileOperation;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author sailfish
 * @create 2019-11-16-7:01 下午
 */
public class AVLTreeTest {

    @Test
    public void addNode() {


        ArrayList<String> list = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt", list);


        AVLTree<String> tree = new AVLTree<>();

        for (String s : list) {
            tree.addNode(s);
        }

        System.out.println("The Tree is BSTree: " + tree.isBST());
        System.out.println("The Tree is AVLTree: " + tree.isBalance());


    }
}