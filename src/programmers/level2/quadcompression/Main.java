package programmers.level2.quadcompression;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }
}

class Solution {
    private int[][] board;
    private int[] answer = new int[2];
    private int cnt0 = 0;
    private int cnt1 = 0;

    public int[] solution(int[][] arr) {
        board = arr;
        dfs(0, 0, arr.length);
        return answer;
    }

    private void dfs(int r, int c, int length) {
        if (length == 1) {
            answer[board[r][c]]++;
            return;
        }
        if (check(r, c, length)) {
            answer[board[r][c]]++;
            return;
        }
        //4번 반복 실행
        int halfLen = length/2;
        dfs(r, c, halfLen);
        dfs(r + halfLen, c, halfLen);
        dfs(r, c + halfLen, halfLen);
        dfs(r + halfLen, c + halfLen, halfLen);
    }

    private boolean check(int r, int c, int length) {
        int val = board[r][c];
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (board[i][j] != val) return false;
            }
        }
        return true;
    }
}

