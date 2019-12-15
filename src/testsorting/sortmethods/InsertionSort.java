package testsorting.sortmethods;

import testsorting.utils.CommonTest;

public class InsertionSort {
    public static final void sort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }

//        for (int i = 0; i < array.length; i++) {
//            Comparable t = array[i];
//            int j;
//            for (j = i - 1; j >= 0; j--) {
//                if (t.compareTo(array[j]) < 0){
//                    array[j + 1] = array[j];
//                } else{
//                    break;
//                }
//            }
//            array[j + 1] = t;
//        }

        for (int i = 0; i < array.length; i++) {
            Comparable t = array[i];
            int j;
            for (j = i - 1; j >= 0 && t.compareTo(array[j]) < 0; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = t;
        }
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
