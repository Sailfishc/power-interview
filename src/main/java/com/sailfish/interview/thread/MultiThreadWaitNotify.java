package com.sailfish.interview.thread;

import java.util.LinkedList;

/**
 * 多线程通信
 * @author sailfish
 * @create 2019-10-15-17:28
 */
public class MultiThreadWaitNotify {

    static class EventQueue {

        private static final int MAX = 10;

        private LinkedList<Event> linkedList = new LinkedList<>();

        public void offer(Event event) {
            synchronized (linkedList) {
                while (linkedList.size() >= MAX) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                linkedList.addLast(event);
                linkedList.notifyAll();
            }
        }


        public Event take() {
            synchronized (linkedList) {
                while (linkedList.isEmpty()) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                final Event event = linkedList.removeFirst();
                linkedList.notifyAll();
                return event;
            }
        }
    }

    static class Event {

    }
}
