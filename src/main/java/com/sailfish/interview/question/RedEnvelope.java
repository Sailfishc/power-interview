package com.sailfish.interview.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author sailfish
 * @create 2020-01-03-3:17 PM
 */
public class RedEnvelope {

    public static List<Integer> generatePacketsByLineCutting(int people, int money) {
        List<Integer> packets = new ArrayList<>();
        Random random = new Random();
        Set<Integer> points = new TreeSet<>();
        while (points.size() < people - 1) {
            points.add(random.nextInt(money - 1));
        }
        points.add(money);
        int pre = 0;
        for (int p : points) {
            packets.add(p - pre);
            pre = p;
        }
        return packets;
    }

    public static void main(String[] args) {
        final List<Integer> result = generatePacketsByLineCutting(10, 100);
        for (Integer money : result) {
            System.out.println(money);
        }
        System.out.println(result.stream().reduce((a, b) -> a + b).get());
    }
}
