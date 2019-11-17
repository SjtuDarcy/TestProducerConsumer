package testSomething;

import testSomething.base.classBBase;
import testSomething.messagepipe.classAMessagePipe;
import testSomething.messagepipe.classBMessagePipe;
import testSomething.pushmanager.classAPushManager;
import testSomething.pushmanager.classBPushManager;

public class TestSomethingMain {
    public static void testMethod() {
//        classBBase.getString();

        classBBase.testMethod(classAMessagePipe.class);
        classBBase.testMethod(classAPushManager.class);


    }
}
