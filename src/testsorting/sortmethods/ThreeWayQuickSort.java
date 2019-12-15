package testsorting.sortmethods;

public class ThreeWayQuickSort {
    public static final void sort(Comparable[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    // 表示对 [left, right] 的范围进行三路快速排序
    private static void sort(Comparable[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, (int) (Math.random() * (right - left + 1)) + left);
        Comparable guard = array[left];

        int equal = left + 1;
        int i = left + 1;
        int gt = right + 1;

        while (i < gt) {
            if (array[i].compareTo(guard) < 0) {
                swap(array, equal, i);
                i++;
                equal++;
            } else if (array[i].compareTo(guard) > 0) {
                swap(array, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(array, left, equal - 1);
        sort(array, left, equal - 1);
        sort(array, gt, right);
    }

    private static void swap(Comparable[] array, int i, int j) {
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
