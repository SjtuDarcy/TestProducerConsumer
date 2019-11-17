package testSomething.base;

import java.lang.reflect.InvocationTargetException;

public class classBBase {

    public static void testMethod(Class<?> cls){
        String str = null;
        try {
            str = (String) cls.getMethod("getString",null).invoke(null,null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("classBBase " + str);
    }
}
