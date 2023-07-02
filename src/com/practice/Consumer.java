package com.practice;

import com.practice.blockingqueue.BlockingQueue;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Consumer(final BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer data = queue.dequeue();
                System.out.println(Thread.currentThread().getName() + " consumed " + data);
                // adding variability
                Thread.sleep(ThreadLocalRandom.current().nextInt(50, 500));
            }
        } catch (InterruptedException e) {
            System.out.println("Terminating thread " + Thread.currentThread().getName() + " due to interrupt");
        }
    }
}

