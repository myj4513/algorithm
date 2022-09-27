package programmers.level3.change;

/**
 * 프로그래머스 레벨 3 - 거스름돈
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, new int[]{1,2,5}));
    }
}

class Solution {
    public int solution(int n, int[] money) {
        int size = money.length;
        int dp[][] = new int[size+1][n+1];
        for (int i = 1; i < size+1; i++) {
            dp[i][money[i-1]]++;
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = (dp[i][j] + dp[i-1][j]) % 1000000007;
                if (j - money[i-1] > 0) {
                    dp[i][j] = (dp[i][j] + dp[i][j-money[i-1]]) % 1000000007;
                }
            }
        }

        return dp[size][n];
    }
}
