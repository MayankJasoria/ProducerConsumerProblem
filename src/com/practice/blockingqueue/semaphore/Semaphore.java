package com.practice.blockingqueue.semaphore;

public class Semaphore {
    private final int maxValue;
    private int permit;

    public Semaphore(int maxValue) {
        this.maxValue = maxValue;
        this.permit = maxValue;
    }

    public Semaphore(int maxValue, int initialPermit) {
        this(maxValue);
        this.permit = initialPermit;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permit == 0) {
            wait();
        }

        --permit;
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (permit == maxValue) {
            wait();
        }
        ++permit;
        notify();
    }
}
