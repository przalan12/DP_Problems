package DP_Problems;

import java.util.*;
import java.io.*;

/*https://open.kattis.com/problems/knapsack*/
public class Knapsack {
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        try {
            for (; ; ) {
                int c = scan.nextInt();
                int n = scan.nextInt();
                int[] weights = new int[n + 1];
                int[] profits = new int[n + 1];
                int[][] dp = new int[n + 1][c + 1];

                for (int i = 1; i <= n; i++) {
                    profits[i] = scan.nextInt();
                    weights[i] = scan.nextInt();
                }
                /*Bottom up approach*/
                //dp[i][j] - max profit for i items with KS capacity of j

                //Base case: dp[0][j] = 0. Considering 0 items results in a profit of 0 for any KS capacity
                //dp[i][0] = 0. Considering i items with a KS capacity of 0 mean nothing can be added aka 0 profit

                // fill base cases
                for (int i = 0; i <= n; i++) dp[i][0] = 0;
                for (int j = 0; j <= c; j++) dp[0][j] = 0;

                //Begin with working our way up by solving smaller subproblems in the table
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= c; j++) {
                        int profit1 = 0;
                        if (weights[i] <= j)
                            profit1 = profits[i] + dp[i - 1][j - weights[i]];
                        dp[i][j] = Math.max(profit1, dp[i - 1][j]);
                    }
                }

                // find which item were included
                StringBuilder ans = new StringBuilder();
                int totalProfit = dp[n][c];
                int itemChosen = 0;
                for (int i = dp.length - 1; i > 0 && totalProfit != 0; i--) {
                    if (totalProfit != dp[i - 1][c]) {
                        ans.append(i - 1).append(" ");
                        c -= weights[i];
                        totalProfit -= profits[i];
                        itemChosen++;
                    }
                }
                pw.println(itemChosen);
                pw.println(ans.toString().trim());

                //        for (int[] line : dp)
                //            System.out.println(Arrays.toString(line));

            }
        } catch (Exception e) {
        }
        pw.close();
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        st = null;
        return str;
    }
}