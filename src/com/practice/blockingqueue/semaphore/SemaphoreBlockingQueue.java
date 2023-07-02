package com.practice.blockingqueue.semaphore;

import com.practice.blockingqueue.BlockingQueue;

import java.lang.reflect.Array;

public class SemaphoreBlockingQueue<T> implements BlockingQueue<T> {

    private final Semaphore binarySem;
    private final Semaphore produceSem;
    private final Semaphore consumeSem;
    private final T[] queue;
    private int head;
    private int tail;
    private int count;

    public SemaphoreBlockingQueue(Class<T> clazz, int maxCapacity) {
        binarySem = new Semaphore(1);
        produceSem = new Semaphore(maxCapacity);
        consumeSem = new Semaphore(maxCapacity, 0);
        queue = (T[]) Array.newInstance(clazz, maxCapacity);
        head = -1;
        tail = -1;
        count = 0;
    }

    @Override
    public void enqueue(T data) throws InterruptedException {
        produceSem.acquire();
        binarySem.acquire();
        if (head == -1) {
            head = 0;
            tail = 0;
        } else {
            head = (head + 1) % queue.length;
        }
        queue[head] = data;
        ++count;
        binarySem.release();
        consumeSem.release();
    }

    @Override
    public T dequeue() throws InterruptedException {
        consumeSem.acquire();
        binarySem.acquire();
        T data = queue[tail];
        tail = (tail + 1) % queue.length;
        --count;
        if (count == 0) {
            head = -1;
            tail = -1;
        }
        binarySem.release();
        produceSem.release();
        return data;
    }
}
