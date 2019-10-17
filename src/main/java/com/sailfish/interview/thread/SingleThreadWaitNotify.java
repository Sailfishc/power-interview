package com.sailfish.interview.thread;

import java.util.LinkedList;

/**
 * @author sailfish
 * @create 2019-10-15-17:28
 */
public class SingleThreadWaitNotify {

    static class EventQueue {

        private static final int MAX = 10;

        private LinkedList<Event> linkedList = new LinkedList<>();

        public void offer(Event event) {
            synchronized (linkedList) {
                if (linkedList.size() >= MAX) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                linkedList.addLast(event);
                linkedList.notify();
            }
        }


        public Event take() {
            synchronized (linkedList) {
                if (linkedList.isEmpty()) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                final Event event = linkedList.removeFirst();
                linkedList.notify();
                return event;
            }
        }
    }

    static class Event {

    }
}
