package testproxy;

public class ManProxy implements IPerson {
    private IPerson target;

    public ManProxy(IPerson target) {
        this.target = target;
    }

    @Override
    public void say() {
        if (target != null) {
            System.out.println("manproxy say");
            target.say();
        }
    }
}
