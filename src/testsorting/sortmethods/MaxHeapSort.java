package testsorting.sortmethods;

import usefuldatastructure.MaxHeap;
import usefuldatastructure.MinHeap;

public class MaxHeapSort {
    public static final void sort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }

//        MaxHeap<Comparable> maxHeap = new MaxHeap<>(array);
//
//        for (int i = 0; i < array.length; i++) {
//            array[array.length - 1 - i] = maxHeap.extractMax();
//        }

        MinHeap<Comparable> minHeap = new MinHeap<>(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = minHeap.extractMax();
        }
    }
}
