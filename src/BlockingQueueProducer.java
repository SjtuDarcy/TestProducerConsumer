import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable{
    private BlockingQueue<String> mBlockQueue;

    public BlockingQueueProducer(BlockingQueue<String> blockQueue) {
        mBlockQueue = blockQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " waiting");

                mBlockQueue.put("testString");

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
