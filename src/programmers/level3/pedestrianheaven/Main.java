package programmers.level3.pedestrianheaven;

/**
 * 프로그래머스 레벨 3 - 보행자 천국
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }
}

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (cityMap[i][j] == 1) {
                    continue;
                }
                int up = i - 1;
                while (up >= 0 && cityMap[up][j] == 2) {
                    up--;
                }
                ;
                if (up >= 0)
                    dp[i][j] = (dp[i][j] + dp[up][j])%MOD;
                int left = j - 1;
                while (left >= 0 && cityMap[i][left] == 2) {
                    left--;
                }
                ;
                if (left >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i][left])%MOD;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
