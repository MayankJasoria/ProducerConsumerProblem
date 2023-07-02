package com.practice;

import com.practice.blockingqueue.BlockingQueue;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer(final BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int data = ThreadLocalRandom.current().nextInt(10000);
                queue.enqueue(data);
                System.out.println(Thread.currentThread().getName() + " produced data " + data);
                // small sleep time for variability
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1000));
            }
        } catch (InterruptedException e) {
            System.out.println("Terminating thread " + Thread.currentThread().getName() + " due to interrupt");
        }
    }
}
