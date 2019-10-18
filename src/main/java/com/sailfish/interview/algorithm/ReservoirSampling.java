package com.sailfish.interview.algorithm;

import java.util.Random;

/**
 * 蓄水池算法
 *  参考：https://www.cnblogs.com/snowInPluto/p/5996269.html
 * @author sailfish
 * @create 2019-10-18-18:02
 */
public class ReservoirSampling {

    private int[] pool;
    private static final int N = 10000;

    private Random random = new Random();

    public ReservoirSampling() {
        pool = new int[N];
        for (int i = 0; i < N; i++) {
            pool[i] = i;
        }
    }


    /**
     * 取前K 元素
     * @param K
     * @return
     */
    public int[] sampling(int K) {
        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            result[i] = pool[i];
        }

        for (int i = K; i < N; i++) {
            // 随机获得一个[0, i]内的随机整数
            final int d = random.nextInt(i + 1);
            if (d < K) {
                // 如果随机整数落在[0, K-1]范围内，则替换蓄水池中的元素
                result[d] = pool[i];
            }
        }
        return result;
    }
}
