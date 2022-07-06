package programmers.level2.tiles3n;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5000));
    }
}

class Solution {
    public int solution(int n) {
        long[] dp = new long[n + 3];
        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] %= 1000000007;
        }
        return (int)dp[n];
    }
}