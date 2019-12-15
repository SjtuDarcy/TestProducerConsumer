package testhashcode;

import java.util.HashMap;
import java.util.Map;

public class TestHashCode {
    private String name;

    public TestHashCode(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        return ((TestHashCode)obj).getName().equals(name);
    }

    public String getName() {
        return name;
    }

    public static void testHashCode() {
        Map<TestHashCode, String> map = new HashMap<>(4);
        TestHashCode hashCode1 = new TestHashCode("hello");
        TestHashCode hashCode2 = new TestHashCode("hello");
        System.out.println("hashCode1 " + hashCode1.hashCode());
        System.out.println("hashCode2 " + hashCode2.hashCode());
        map.put(hashCode1, "hello");
        String hello = map.get(hashCode2);
        System.out.println(hello);
    }
}
