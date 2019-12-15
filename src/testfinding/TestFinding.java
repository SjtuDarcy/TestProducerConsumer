package testfinding;

import testfinding.findmethods.BinarySearch;
import testsorting.utils.CommonTest;
import testsorting.utils.SortTestHelper;
import testsorting.utils.Student;

public class TestFinding {
    public static final void TestFinding() {
        System.out.println("testIntSize10AndPrint");
        Integer array[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(BinarySearch.find(array,11));
        System.out.println(BinarySearch.find(array,7));
    }
}
