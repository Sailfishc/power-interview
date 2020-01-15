package com.sailfish.interview.algorithm.recursion;


/**
 * 递归打印数字
 */
public class PrintNumDemo {


    public void printNum(int n) {
        if (n == 0) {
            return;
        }

        printNum(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        PrintNumDemo printNumDemo = new PrintNumDemo();
        printNumDemo.printNum(6);

    }
}
