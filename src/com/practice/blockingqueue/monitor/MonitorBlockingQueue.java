package com.practice.blockingqueue.monitor;

import com.practice.blockingqueue.BlockingQueue;

import java.lang.reflect.Array;

public class MonitorBlockingQueue<T> implements BlockingQueue<T> {

    private final T[] queue;
    private int head;
    private int tail;
    private int count;

    public MonitorBlockingQueue(Class<T> clazz, int size) {
        queue = (T[]) Array.newInstance(clazz, size);
        head = -1;
        tail = -1;
        count = 0;
    }

    @Override
    public synchronized void enqueue(T data) throws InterruptedException {
        while (count == queue.length) {
            wait();
        }
        if (head == -1) {
            head = 0;
            tail = 0;
        } else {
            head = (head + 1) % queue.length;
        }
        queue[head] = data;
        ++count;
        // ensures that at least one consumer is awoken
        notifyAll();
    }

    @Override
    public synchronized T dequeue() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        // tail is definitely not -1
        T data = queue[tail];
        tail = (tail + 1) % queue.length;
        --count;
        if (count == 0) {
            tail = -1;
            head = -1;
        }
        // ensures that at least one producer is awoken
        notifyAll();

        return data;
    }
}
