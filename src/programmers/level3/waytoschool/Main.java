package programmers.level3.waytoschool;

/**
 * 프로그래머스 레벨 3 - 등굣길
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, 3, new int[][]{{2, 2}}));
    }
}

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                boolean isPuddle = false;
                for (int k = 0; k < puddles.length; k++) {
                    if (puddles[k][0] == j && puddles[k][1] == i) {
                        isPuddle = true;
                        break;
                    }
                }
                if (isPuddle) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        return dp[n][m];
    }
}