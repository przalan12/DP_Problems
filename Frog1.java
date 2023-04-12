package DP_Problems;

import java.util.*;

public class Frog1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] cost = new int[n + 1];

        for (int i = 0; i < n; i++)
            cost[i] = scan.nextInt();


        int[] dp = new int[n];

        //base case.
        dp[0] = 0;
        dp[1] = Math.abs(cost[0] - cost[1]);


        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(
                    Math.abs(cost[i] - cost[i - 1]) + dp[i - 1],
                    Math.abs(cost[i] - cost[i - 2]) + dp[i - 2]
            );
        }

//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n - 1]);


    }
}
