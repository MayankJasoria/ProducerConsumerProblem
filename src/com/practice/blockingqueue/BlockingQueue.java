package com.practice.blockingqueue;

public interface BlockingQueue<T> {
    void enqueue(T data) throws InterruptedException;
    T dequeue() throws InterruptedException;
}
