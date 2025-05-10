package SemesterWork_ShellSort;

import java.util.*;

public class DataGenerator {
    public static List<int[]> generateData(int numberOfArrays, int minSize, int maxSize) {
        Random rand = new Random();
        List<int[]> dataSets = new ArrayList<>();

        for (int i = 0; i < numberOfArrays; i++) {
            int size = rand.nextInt(maxSize - minSize + 1) + minSize;
            int[] data = new int[size];
            for (int j = 0; j < size; j++) {
                data[j] = rand.nextInt(100000);
            }
            dataSets.add(data);
        }

        return dataSets;
    }
}