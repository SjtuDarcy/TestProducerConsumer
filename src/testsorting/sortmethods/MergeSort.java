package testsorting.sortmethods;

import java.util.Arrays;

public class MergeSort {
    public static final void sort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    // 排序sort，范围为[left,right]
    private static void sort(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        sort(array, left, mid - 1);
        sort(array, mid + 1, right);
        if (array[mid].compareTo(array[mid + 1]) > 0) {
            merge(array, left, mid, right);
        }
    }

    private static void merge(Comparable[] array, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // 只是拷贝了需要归并的一段
        Comparable[] tempArray = Arrays.copyOfRange(array, left, right + 1);

        while (k <= right) {
            if (i > mid) { // 如果左边的全部比较完了
                array[k] = tempArray[j - left];
                j++;
            } else if (j > right) { // 如果右边的全部比较完了
                array[k] = tempArray[i - left];
                i++;
            } else if (tempArray[i - left].compareTo(tempArray[j - left]) < 0) { // 如果左边比右边小
                array[k] = tempArray[i - left];
                i++;
            } else { // 如果右边比左边小
                array[k] = tempArray[j - left];
                j++;
            }
            k++;
        }
    }
}
