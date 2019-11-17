package testjoin;

public class TestJoinMain {
    public void testJoin() {
        ThreadJoinTest test1 = new ThreadJoinTest("A");
        ThreadJoinTest test2 = new ThreadJoinTest("B");
        test1.start();
        /**
         * join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
         * 程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
         * 所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
         */
        try {
            test1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2.start();
    }


    class ThreadJoinTest extends Thread{
        public ThreadJoinTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i< 1000;i++) {
                System.out.println(getName() + ":" + i);
            }
        }
    }

    public void testJoinPrinciple() {
        ThreadJoinTestPrinciple test1 = new ThreadJoinTestPrinciple("A");
        ThreadJoinTestPrinciple test2 = new ThreadJoinTestPrinciple("B");
        test1.start();
        try {
            synchronized (test1){
                test1.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2.start();
    }

    class ThreadJoinTestPrinciple extends Thread{
        public ThreadJoinTestPrinciple(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i< 1000;i++) {
                System.out.println(getName() + ":" + i);
            }
            synchronized (this){
                notifyAll();
            }
        }
    }


}
