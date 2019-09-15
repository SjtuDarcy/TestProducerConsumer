package testproducerconsumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockConsumer implements Runnable {
    private Queue<String> mQueue;

    private Lock mLock;
    private Condition mFullCondition;
    private Condition mEmptyCondition;

    public LockConsumer(Queue<String> queue, Lock lock, Condition fullCondition, Condition emptyCondition) {
        mQueue = queue;
        mLock = lock;
        mFullCondition = fullCondition;
        mEmptyCondition = emptyCondition;
    }

    @Override
    public void run() {
        while (true) {
            mLock.lock();
            while (mQueue.size() == 0) {
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting");
                try {
                    mEmptyCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " awake");
            }
            mQueue.poll();
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " size = " + mQueue.size());
            mFullCondition.signalAll();
            mLock.unlock();

            Utils.randomDelay(1000);
        }
    }
}
