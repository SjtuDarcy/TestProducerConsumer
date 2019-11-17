package testproxy;

import java.lang.reflect.Proxy;

public class TestDynamicProxy {
    public static void testDynamicProxy() {
        NormalHandler normalHandler = new NormalHandler();
        IPerson iPerson = (IPerson)normalHandler.bind(new Man());
        iPerson.say();
    }
}
