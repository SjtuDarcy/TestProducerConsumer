package testproducerconsumer;

import java.util.Queue;
import java.util.Random;

public class SynchronizedConsumer implements Runnable {
    private Queue<String> mQueue;

    public SynchronizedConsumer(Queue<String> queue) {
        mQueue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (mQueue) {
                while (mQueue.size() == 0) {
                    try {
                        mQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mQueue.poll();
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " size = " + mQueue.size());
                mQueue.notifyAll();
            }
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Utils.randomDelay(1000);
        }
    }
}
