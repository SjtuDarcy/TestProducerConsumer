import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int CAPACITY = 5;

    public static void main(String[] args) {
//        testSynchronizedLock();
        testLockLock();
    }

    private static void testLockLock() {
        LinkedList<String> linkedList = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition fullCondition = lock.newCondition();
        Condition emptyCondition = lock.newCondition();

        Runnable producerRunnable = new LockProducer(linkedList, CAPACITY, lock, fullCondition, emptyCondition);
        Thread producer1 = new Thread(producerRunnable, "producer1");
        Thread producer2 = new Thread(producerRunnable, "producer2");
        Thread producer3 = new Thread(producerRunnable, "producer3");
        producer1.start();
        producer2.start();
        producer3.start();

        Runnable consumerRunnable = new LockConsumer(linkedList, lock, fullCondition, emptyCondition);
        Thread consumer1 = new Thread(consumerRunnable, "consumer1");
        Thread consumer2 = new Thread(consumerRunnable, "consumer2");
        consumer1.start();
        consumer2.start();
    }


    private static void testSynchronizedLock() {
        LinkedList<String> linkedList = new LinkedList<>();
        // 这个锁可以直接使用 linkedList，这个也是全局唯一的
//        Object lock = new Object();

        Runnable producerRunnable = new SynchronizedProducer(linkedList, CAPACITY);
        Thread producer1 = new Thread(producerRunnable, "producer1");
        Thread producer2 = new Thread(producerRunnable, "producer2");
        Thread producer3 = new Thread(producerRunnable, "producer3");
        producer1.start();
        producer2.start();
        producer3.start();

        Runnable consumerRunnable = new SynchronizedConsumer(linkedList);
        Thread consumer1 = new Thread(consumerRunnable, "consumer1");
        Thread consumer2 = new Thread(consumerRunnable, "consumer2");
        consumer1.start();
        consumer2.start();
    }
}
