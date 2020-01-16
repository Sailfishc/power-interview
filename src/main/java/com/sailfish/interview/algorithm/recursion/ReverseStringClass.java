package com.sailfish.interview.algorithm.recursion;

public class ReverseStringClass {


    public static String reverseString(String myStr) {

        // Base case
        if (myStr.isEmpty()) {
            return myStr;
        }

        return reverseString(myStr.substring(1)) + myStr.charAt(0);
    }


    public static void main(String[] args) {
        String string1 = "Hello World";
        String string2 = "Reverse";

        System.out.println( "The Original String is: ");
        System.out.println(string1);

        String resultStr = reverseString(string1);

        System.out.println("String after reversal: ");
        System.out.println(resultStr);
    }
}
