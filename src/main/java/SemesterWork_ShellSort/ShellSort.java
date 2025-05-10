package SemesterWork_ShellSort;

public class ShellSort {
    public static long iterationCount = 0;

    public static void shellSort(int[] array) {
        int size = array.length;
        iterationCount = 0;

        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                    iterationCount++;
                }
                array[j] = temp;
                iterationCount++;
            }
        }
    }
}