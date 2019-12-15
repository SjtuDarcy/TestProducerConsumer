package testsorting.sortmethods;

public class QuickSort {
    public static final void sort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        sort(array, left, right);
    }

    // 表示对 [left, right] 的范围进行快速排序
    private static void sort(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);
        int mid = partition(array, left, right);
        sort(array, left, mid - 1);
        sort(array, mid + 1, right);
    }

    private static int partition(Comparable[] array, int left, int right) {
        Comparable compareValue = array[left];
        // 表示比v大的第一个的位置
        int j = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (array[i].compareTo(compareValue) < 0) {
                swap(array, i, j);
                j++;
            }
        }
        swap(array, left, j - 1);
        return j - 1;
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
