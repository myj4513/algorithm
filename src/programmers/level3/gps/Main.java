package programmers.level3.gps;

/**
 * 프로그래머스 레벨 3 자물쇠와 열쇠
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(7, 10, new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}}, 2, new int[]{1, 7}));
    }
}

class Solution {
    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        List<List<Integer>> graph = new ArrayList<>(); //그래프 생성
        for (int i = 0; i <= n; i++) { //그래프 초기화
            graph.add(new ArrayList<>());
            graph.get(i).add(i);
        }
        for (int i = 0; i < m; i++) { //edge 생성
            graph.get(edge_list[i][0]).add(edge_list[i][1]);
            graph.get(edge_list[i][1]).add(edge_list[i][0]);
        }

        int[][] dp = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][gps_log[0]] = 0;
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int before : graph.get(j)) {
                    if (dp[i - 1][before] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][before] + ((j == gps_log[i] ? 0 : 1)));
                    }
                }
            }
        }

        return dp[k - 1][gps_log[k-1]] == Integer.MAX_VALUE ? -1 : dp[k - 1][gps_log[k-1]];
    }
}
