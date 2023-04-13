package DP_Problems;

import java.util.*;

public class Frog2 {
    static int inf = (int) 1e18;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] cost = new int[n];

        for (int i = 0; i < n; i++)
            cost[i] = scan.nextInt();

        int[] dp = new int[n];

        Arrays.fill(dp, inf);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i],
                            Math.abs(cost[i] - cost[i - j]) + dp[i - j]);
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n - 1]);

    }
}
