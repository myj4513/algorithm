package programmers.level2.biggestsquare;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }
}

class Solution {
    public int solution(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        dp[0] = board[0];
        for (int i = 0; i < board.length; i++) {
            dp[i][0] = board[i][0];
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0)
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
