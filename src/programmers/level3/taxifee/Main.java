package programmers.level3.taxifee;

import java.util.Arrays;

/**
 * 프로그래머스 레벨 3 - 택시 합승 요금
 */

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
        System.out.println(new Solution().solution(7, 3, 4, 1, new int[][]{{5, 7, 9},{4, 6, 4},{3, 6, 1},{3, 2, 3},{2, 1, 6}}));
//        System.out.println(new Solution().solution(	6, 4, 5, 6,new int[][]{{2, 6, 6},{6, 3, 7},{4, 6, 7},{6, 5, 11},{2, 5, 12},{5, 3, 20},{2, 4, 8},{4, 3, 9}}));
    }
}

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        //일단 그래프를 그리자
        //인접 행렬을 만들면 쉬워질것 같다
        int[][] fee = new int[n + 1][n + 1];
        for (int i = 0; i < fee.length; i++) {
            Arrays.fill(fee[i], Integer.MAX_VALUE);
            fee[i][i] = 0;
        }
        for (int i = 0; i < fares.length; i++) {
            fee[fares[i][0]][fares[i][1]] = fares[i][2];
            fee[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(fee[i][k] == Integer.MAX_VALUE || fee[k][j] == Integer.MAX_VALUE) continue;
                    fee[i][j] = Math.min(fee[i][j], fee[i][k] + fee[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if(fee[s][i] == Integer.MAX_VALUE || fee[i][a] == Integer.MAX_VALUE || fee[i][b] == Integer.MAX_VALUE) continue;
            min = Math.min(min, fee[s][i] + fee[i][a] + fee[i][b]);
        }

        return min;
    }
}