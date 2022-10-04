package programmers.level3.nondestroyedbuilding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 레벨 3 - 파괴되지 않은 건물
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
    }
}

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefixSum = new int[board.length+2][board[0].length+2];
        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1]+1;
            int c1 = skill[i][2]+1;
            int r2 = skill[i][3]+1;
            int c2 = skill[i][4]+1;
            int degree = type==1? -1 * skill[i][5] : skill[i][5];
            prefixSum[r1][c1] += degree;
            prefixSum[r1][c2+1] -= degree;
            prefixSum[r2+1][c1] -= degree;
            prefixSum[r2+1][c2+1] += degree;
        }
        int answer = 0;
        for (int i = 1; i < board.length+1; i++) {
            for (int j = 1; j < board[0].length+1; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + prefixSum[i][j];
                if (board[i - 1][j - 1] + prefixSum[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}