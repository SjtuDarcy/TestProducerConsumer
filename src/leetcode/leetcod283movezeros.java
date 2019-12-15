package leetcode;

import java.util.Arrays;

public class leetcod283movezeros {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        Arrays.fill(nums, index, nums.length, 0);
    }
}
