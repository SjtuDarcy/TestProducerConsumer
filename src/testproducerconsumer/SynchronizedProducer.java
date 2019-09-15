package testproducerconsumer;

import java.util.Queue;
import java.util.Random;

public class SynchronizedProducer implements Runnable {
    private Queue<String> mQueue;

    private int mMaxQueueSize;

    public SynchronizedProducer(Queue<String> queue, int maxQueueSize) {
        mQueue = queue;
        mMaxQueueSize = maxQueueSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mQueue) {
                while (mQueue.size() == mMaxQueueSize) {
                    try {
                        mQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mQueue.offer("testString");
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " size = " + mQueue.size());
                mQueue.notifyAll();
            }
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Utils.randomDelay(1000);
        }
    }
}
