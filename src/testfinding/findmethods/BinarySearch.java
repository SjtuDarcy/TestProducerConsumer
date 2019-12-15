package testfinding.findmethods;

public class BinarySearch {
    public static int find(Comparable[] array, Comparable target) {
        return find(array, 0, array.length - 1, target);
    }

    private static int find(Comparable[] array, int left, int right, Comparable target) {
        if (left > right) {
            return -1;
        }

        // 注意一下，放置整数溢出
        int mid = left + (right - left) / 2;
        int result = array[mid].compareTo(target);
        if (result == 0) {
            return mid;
        } else if (result > 0) {
            return find(array, left, mid - 1, target);
        } else {
            return find(array, mid + 1, right, target);
        }
    }
}