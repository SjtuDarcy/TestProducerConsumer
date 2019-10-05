package testdesignpattern.singletonpattern;

public class SingletonHungryMan {
    private SingletonHungryMan() {
    }

    private static final SingletonHungryMan sSingletonHungryMan = new SingletonHungryMan();

    /**
     * 饿汉模式
     *
     * @return 单例
     */
    public static SingletonHungryMan getInstance() {
        return sSingletonHungryMan;
    }
}
