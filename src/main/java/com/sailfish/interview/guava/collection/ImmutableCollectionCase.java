package com.sailfish.interview.guava.collection;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * https://github.com/google/guava/wiki/ImmutableCollectionsExplained
 *
 * @author sailfish
 * @create 2020-03-10-5:29 PM
 */
public class ImmutableCollectionCase {


}

class Foo {
    final ImmutableSet<Bar> bars;

    Foo(Set<Bar> bars) {
        this.bars = ImmutableSet.copyOf(bars); // defensive copy!
    }

    private class Bar {

    }
}