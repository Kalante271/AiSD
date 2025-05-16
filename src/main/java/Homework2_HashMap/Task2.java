package Homework2_HashMap;

import java.util.*;

public class Task2 {
    public static boolean check(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (map.containsKey(num)) {
                int j = map.get(num);

                if (i - j <= k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }
}
