package testsorting.utils;

public class CommonTest {
    public static final void testSort(String className) {
        testNull(className);
        testIntSize0AndPrint(className);
        testIntSize1AndPrint(className);
        testIntSize3AndPrint(className);
        testIntSize10AndPrint(className);
        testDoubleSize10AndPrint(className);
        testStudentSize4AndPrint(className);
        testRandomNumber(className);
    }

    private static void testIntSize3AndPrint(String className) {
        System.out.println("testIntSize1AndPrint");
        Integer array[] = {2,0,1};
        SortTestHelper.testSort(className, array, true);
        System.out.println();
    }

    private static void testNull(String className) {
        System.out.println("testNull");
        Integer array[] = null;
        SortTestHelper.testSort(className, array, false);
        System.out.println();
    }

    private static void testIntSize0AndPrint(String className) {
        System.out.println("testIntSize0AndPrint");
        Integer array[] = {};
        SortTestHelper.testSort(className, array, true);
        System.out.println();
    }

    private static void testIntSize1AndPrint(String className) {
        System.out.println("testIntSize1AndPrint");
        Integer array[] = {3};
        SortTestHelper.testSort(className, array, true);
        System.out.println();
    }


    private static void testIntSize10AndPrint(String className) {
        System.out.println("testIntSize10AndPrint");
        Integer array[] = {2, 3, 8, 4, 6, 5, 7, 8, 10, 9, 1};
        SortTestHelper.testSort(className, array, true);
        System.out.println();
    }

    private static void testDoubleSize10AndPrint(String className) {
        System.out.println("testDoubleSize10AndPrint");
        Double array[] = {2.1, 3.5, 8.0};
        SortTestHelper.testSort(className, array, true);
        System.out.println();

    }

    private static void testStudentSize4AndPrint(String className) {
        System.out.println("testStudentSize4AndPrint");
        Student students[] = {new Student("xiaoming", 98),
            new Student("xiaoming", 89),
            new Student("xiaohong", 89),
            new Student("xiaohong", 99)
        };
        SortTestHelper.testSort(className, students, true);
        System.out.println();
    }

    private static void testRandomNumber(String className) {
        System.out.println("testRandomNumber 10000");
        Integer array[] = SortTestHelper.generateRandomArray(100000, 2, 1000);
        SortTestHelper.testSort(className, array, true);
        System.out.println();
    }
}
