package Homework7;

import java.util.*;

public class Task2 {
    public static boolean canWin(int n, Map<Integer, List<Integer>> moves) {
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!moves.containsKey(i)) {
                dp[i] = false;
                continue;
            }

            for (int move : moves.get(i)) {
                if (i - move >= 0 && !dp[i - move]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}