package Homework6_DP;

import java.util.Random;
import java.util.Scanner;

public class Turtle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введите количество строк (n): ");
        int n = scanner.nextInt();
        System.out.print("Введите количество столбцов (m): ");
        int m = scanner.nextInt();

        int[][] cost = new int[n][m];
        System.out.println("\nМатрица цен:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = random.nextInt(9) + 1;
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }

        int[][] dp = new int[n][m];

        dp[0][0] = cost[0][0];

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
            }
        }

        System.out.println("\nМинимальная сумма для прохождения: " + dp[n - 1][m - 1]);
    }
}
