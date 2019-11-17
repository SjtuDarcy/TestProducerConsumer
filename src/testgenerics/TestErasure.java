package testgenerics;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class TestErasure {
    public static void testErasureReflect() {
        ArrayList<String> str = new ArrayList<>();
//        str.add("string");
//        str.add(1);
        try {
            Class clz = str.getClass();
            Method method = clz.getDeclaredMethod("add", Object.class);
            method.invoke(str, "string");
            method.invoke(str, 1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (Object o : str) {
            System.out.println(o);
        }
    }


    public static void testErasure() {
        Erasure<String> erasure = new Erasure<String>("hello");
        Class clz = erasure.getClass();
        System.out.println("erasure class is:" + clz.getName());
        Field[] fs = clz.getDeclaredFields();
        for (Field f : fs) {
            System.out.println("Field name " + f.getName() + " type:" + f.getType().getName());
        }

        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method :" + method.toString());
        }

    }

    public static class Erasure<T> {
        T mObject;

        public Erasure(T object) {
            this.mObject = object;
        }

        public T add(T a) {
            return a;
        }
    }

    public static class ErasureString<T extends String> {
        T mObject;

        public ErasureString(T object) {
            this.mObject = object;
        }
    }
}
