package SemesterWork_ShellSort;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static SemesterWork_ShellSort.ShellSort.*;

public class Main {
    public static void main(String[] args) {
        int numberOfArrays = 100;
        int minSize = 100;
        int maxSize = 10000;

        List<int[]> dataSets = DataGenerator.generateData(numberOfArrays, minSize, maxSize);

        try (PrintWriter writer = new PrintWriter("results.csv")) {
            writer.println("ArrayNumber,ArraySize,Time,Iterations");

            for (int i = 0; i < 5; i++) {
                int[] warmup = DataGenerator.generateData(1, 1000, 2000).get(0);
                shellSort(warmup);
            }

            for (int i = 0; i < dataSets.size(); i++) {
                int[] data = Arrays.copyOf(dataSets.get(i), dataSets.get(i).length);

                long startTime = System.nanoTime();
                shellSort(data);
                long endTime = System.nanoTime();

                long duration = endTime - startTime;

                writer.printf("%d,%d,%d,%d%n", i + 1, data.length, duration, iterationCount);
                System.out.printf("Набор #%d | Размер: %d | Время: %d нс | Итерации: %d%n",
                        i + 1, data.length, duration, iterationCount);
            }

            System.out.println("Данные сохранены в файл results.csv");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}