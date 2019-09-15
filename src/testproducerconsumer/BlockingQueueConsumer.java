package testproducerconsumer;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable {
    private BlockingQueue<String> mBlockQueue;

    public BlockingQueueConsumer(BlockingQueue<String> blockQueue) {
        mBlockQueue = blockQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting");

                mBlockQueue.take();

                System.out.println("Thread " + Thread.currentThread().getName() + " awake");
                System.out.println("Thread " + Thread.currentThread().getName()
                    + " size = " + mBlockQueue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Utils.randomDelay(1000);
        }
    }
}
