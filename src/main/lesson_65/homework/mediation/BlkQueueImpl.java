package main.lesson_65.homework.mediation;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlkQueueImpl<T> implements BlkQueue<T> {

    int maxSize;
    LinkedList<T> list;
    Lock mutex = new ReentrantLock();
    Condition senderWaitingCondition = mutex.newCondition();
    Condition receiverWaitingCondition = mutex.newCondition();

    public BlkQueueImpl(int maxSize) {
        this.maxSize = maxSize;
        this.list = new LinkedList<>();
    }

    @Override
    public void push(T message) {
        mutex.lock();
        try {
            while (list.size() >= maxSize) {
                try {
                    senderWaitingCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(message);
            receiverWaitingCondition.signal();
        } finally {
            mutex.unlock();
        }
    }

    @Override
    public T pop() {
        mutex.lock();
        try {
            while (list.isEmpty()) {
                try {
                    receiverWaitingCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T result = list.removeFirst();
            senderWaitingCondition.signal();
            return result;
        } finally {
            mutex.unlock();
        }
    }
}
