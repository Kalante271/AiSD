package Homework4_Sorting;

import java.util.Arrays;

public class Task3 {
    public static String printLargestNumber(int[] nums) {
        String[] strNums = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        if (strNums[0].equals("0")) return "0";
        return String.join("", strNums);
    }
}
