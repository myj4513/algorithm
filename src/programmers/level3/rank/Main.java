package programmers.level3.rank;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] floyd = new boolean[n][n];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0]-1;
            int loser = results[i][1]-1;
            floyd[winner][loser] = true;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (floyd[i][k] && floyd[k][j]) {
                        floyd[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (floyd[i][j] || floyd[j][i]) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}
