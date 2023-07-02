package com.practice;

import com.practice.blockingqueue.BlockingQueue;
import com.practice.blockingqueue.monitor.MonitorBlockingQueue;
import com.practice.blockingqueue.semaphore.SemaphoreBlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Testing with monitor queue: ");
        int producerCount = ThreadLocalRandom.current().nextInt(5) + 1;
        int consumerCount = ThreadLocalRandom.current().nextInt(15) + 1;
        int queueSize = 1;//ThreadLocalRandom.current().nextInt(10, 21);
        simulateProblem(producerCount, consumerCount, queueSize, new MonitorBlockingQueue<>(Integer.class, queueSize));
        System.out.println();
        System.out.println("Testing with semaphore queue: ");
        simulateProblem(producerCount, consumerCount, queueSize, new SemaphoreBlockingQueue<>(Integer.class, queueSize));
    }

    public static void simulateProblem(int producerCount, int consumerCount, int queueSize, BlockingQueue<Integer> bq) throws InterruptedException {
        List<Thread> producers = new ArrayList<>();
        List<Thread> consumers = new ArrayList<>();

        for (int i = 1; i <= producerCount; ++i) {
            Thread thread = new Thread(new Producer(bq));
            thread.setName("Producer-" + i);
            producers.add(thread);
        }

        for (int i = 1; i <= consumerCount; ++i) {
            Thread thread = new Thread(new Consumer(bq));
            thread.setName("Consumer-" + i);
            consumers.add(thread);
        }

        System.out.println("Created " + producerCount + " producers and " + consumerCount + " consumers to use a blocking queue of size " + queueSize);

        // start all threads
        for (Thread t : consumers) {
            t.start();
        }
        for (Thread t : producers) {
            t.start();
        }

        // sleep for 10 seconds
        Thread.sleep(10_000);

        // using interrupt to terminate threads
        for (Thread t : producers) {
            t.interrupt();
        }

        for (Thread t : producers) {
            t.join();
        }

        // allow consumers to empty queue in 2 seconds
        Thread.sleep(2000);

        for (Thread t : consumers) {
            t.interrupt();
        }

        for (Thread t : consumers) {
            t.join();
        }

        System.out.println("All threads have been terminated.");
    }
}
