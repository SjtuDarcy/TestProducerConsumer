package testsorting.sortmethods;

public class BubbleSort {
    public static final void sort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }

//        // 160ms
//        int n = array.length;
//        int maxIndex;
//
//        do {
//            maxIndex = 0;
//            for (int i = 0; i < n - 1; i++) {
//                if (array[i].compareTo(array[i + 1]) > 0) {
//                    swap(array, i, i + 1);
//                    maxIndex = i;
//                }
//            }
//            n = maxIndex;
//        } while (n > 0);
//    }


//        // 423ms
//        boolean isSwap;
//        do {
//            isSwap = false;
//            for (int i = 0; i < array.length - 1; i++) {
//                if (array[i].compareTo(array[i + 1]) > 0) {
//                    swap(array, i, i + 1);
//                    isSwap = true;
//                }
//            }
//        } while (isSwap);



        // 310ms
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}

