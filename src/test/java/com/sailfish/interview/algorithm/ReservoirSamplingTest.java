package com.sailfish.interview.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sailfish
 * @create 2019-10-18-18:07
 */
public class ReservoirSamplingTest {

    @Test
    public void sampling() {
        ReservoirSampling sampling = new ReservoirSampling();
        for (int i : sampling.sampling(100)) {
            System.out.println(i);
        }
    }
}