package testproxy;

public class TestStaticProxy {
    public static void testStaticProxy() {
        IPerson person = new ManProxy(new Man());
        person.say();
    }
}
