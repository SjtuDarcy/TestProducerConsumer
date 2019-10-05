package testdesignpattern.singletonpattern;

public class SingletonLazyMan {
    private SingletonLazyMan() {
    }

    private static SingletonLazyMan sSingletonLazyMan = null;

    /**
     * 懒汉式单例
     * 并发会有问题
     *
     * @return 单例
     */
    public static SingletonLazyMan getInstance(){
        if(sSingletonLazyMan == null) {
            sSingletonLazyMan = new SingletonLazyMan();
        }
        return sSingletonLazyMan;
    }

    /**
     * 懒汉式单例
     * 每次getInstance都会上锁，性能差
     *
     * @return 单例
     */
    public static synchronized SingletonLazyMan getInstance1(){
        if(sSingletonLazyMan == null) {
            sSingletonLazyMan = new SingletonLazyMan();
        }
        return sSingletonLazyMan;
    }


//    private volatile static SingletonLazyMan sSingletonLazyMan = null;

    /**
     * 懒汉式单例
     * 性能也好了，只有当没有new的时候才会上锁
     *
     * @return 单例
     */
    public static SingletonLazyMan getInstance2(){
        if(sSingletonLazyMan == null) {
            synchronized (SingletonLazyMan.class) {
                if(sSingletonLazyMan == null) {
                    sSingletonLazyMan = new SingletonLazyMan();
                }
            }
        }
        return sSingletonLazyMan;
    }

    /**
     * 静态内部类
     *
     * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，
     * 它跟饿汉模式不同，饿汉模式只要 Singleton 类被装载了，那么 instance
     * 就会被实例化（没有达到 lazy loading 效果），而这种方式是 Singleton 类被装载了，
     * instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式
     * 调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance
     */
    private static class LazyHolder{
        private static final SingletonLazyMan INSTANCE = new SingletonLazyMan();
    }

    public static final SingletonLazyMan getInstance3(){
        return LazyHolder.INSTANCE;
    }

}
