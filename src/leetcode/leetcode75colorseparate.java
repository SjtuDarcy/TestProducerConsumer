package leetcode;

import utils.ArrayUtils;

public class leetcode75colorseparate {
    // 使用三路快排的方法，但是标定点不能是第一个数，而应该是1
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int zero = -1; // [0,zero]表示的是0
        int two = nums.length; // [two, nums.length - 1] 表示的是2
        int i = 0;

        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else { // nums[i] == 2
                two--;
                swap(nums, i, two);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void test75() {
        System.out.println("test75");
        int array[] = {2, 0, 1};
        sortColors(array);
        ArrayUtils.printArray(array);
    }
}
