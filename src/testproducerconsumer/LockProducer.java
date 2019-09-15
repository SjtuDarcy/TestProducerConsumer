package testproducerconsumer;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class LockProducer implements Runnable {
    private Queue<String> mQueue;
    private int mMaxQueueSize;

    private Lock mLock;
    private Condition mFullCondition;
    private Condition mEmptyCondition;

    public LockProducer(Queue<String> queue, int maxQueueSize, Lock lock, Condition fullCondition, Condition emptyCondition) {
        mQueue = queue;
        mMaxQueueSize = maxQueueSize;
        mLock = lock;
        mFullCondition = fullCondition;
        mEmptyCondition = emptyCondition;
    }

    @Override
    public void run() {
        while (true) {
            mLock.lock();
            while (mQueue.size() == mMaxQueueSize) {
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting");
                try {
                    mFullCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " awake");
            }
            mQueue.offer("testString");
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " size = " + mQueue.size());
            mEmptyCondition.signalAll();
            mLock.unlock();

            Utils.randomDelay(1000);
        }
    }
}
