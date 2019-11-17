package testproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NormalHandler implements InvocationHandler {

    private Object mTarget;

    public NormalHandler() {
    }

    public NormalHandler(Object target) {
        mTarget = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("normal hander say");
        method.invoke(mTarget, args);
        return null;
    }

    public Object bind(Object target) {
        mTarget = target;
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            this);
    }
}
