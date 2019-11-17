package testgenerics;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

    public static void TestSuperGenerics() {
        //List<? super Animal> list = new ArrayList<Animal>();
        List<? super Animal> list = new ArrayList<Object>();
        testSuperAdd(list);
    }

    public static void testSuperAdd(List<? super Animal> list){
//        list.add(new Object());
        list.add(new Bird());
        list.add(new Cat());
    }


    public static void TestExtendsGenerics() {
        List<? extends Animal> list = new ArrayList<Bird>();
//        testExtendsAdd(list);
    }

    public static void testExtendsAdd(List<? extends Animal> list){
//        list.add(new Animal());
//        list.add(new Bird());
//        list.add(new Cat());
    }

    public static class Animal {
        public Animal() {
        }
    }

    public static class Bird extends Animal {
        public Bird() {
        }
    }

    public static class Cat extends Animal {
        public Cat() {
        }
    }
}
