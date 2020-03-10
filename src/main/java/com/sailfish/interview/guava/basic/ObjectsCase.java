package com.sailfish.interview.guava.basic;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * @author sailfish
 * @create 2020-03-10-5:17 PM
 */
public class ObjectsCase {

    public static void main(String[] args) {
        // equals
        System.out.println(Objects.equal(1, 2));
        System.out.println(Objects.equal("a", "a")); // returns true
        System.out.println(Objects.equal(null, "a")); // returns false
        System.out.println(Objects.equal("a", null)); // returns false
        System.out.println(Objects.equal(null, null)); // returns true

        // toString
        // Returns "ClassName{x=1}"
//        MoreObjects.toStringHelper(this)
//                .add("x", 1)
//                .toString();

        // Returns "MyObject{x=1}"
        System.out.println(MoreObjects.toStringHelper("MyObject")
                .add("x", 1)
                .toString());
    }

    /**
     * @author sailfish
     * @create 2020-03-10-5:23 PM
     */
    public static class Foo {

        private String aString;
        private int anInt;
        private Enum anEnum;

        // Guava compareTo
        public int compareTo(Foo that) {
            return ComparisonChain.start()
                    .compare(this.aString, that.aString)
                    .compare(this.anInt, that.anInt)
                    .compare(this.anEnum, that.anEnum, Ordering.natural().nullsLast())
                    .result();
        }
    }

    /**
     * @author sailfish
     * @create 2020-03-10-5:22 PM
     */
    public static class Person implements Comparable<Person> {
        private String lastName;
        private String firstName;
        private int zipCode;


        // JDK compare
        public int compareTo(Person other) {
            int cmp = lastName.compareTo(other.lastName);
            if (cmp != 0) {
                return cmp;
            }
            cmp = firstName.compareTo(other.firstName);
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(zipCode, other.zipCode);
        }


    }
}
