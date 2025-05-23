package Homework4_Sorting;

import java.util.Arrays;

public class Task4 {
    public static int maxCount(int[] nums, int s) {
        Arrays.sort(nums);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            if (sum + num <= s) {
                sum += num;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
