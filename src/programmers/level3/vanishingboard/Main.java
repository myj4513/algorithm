package programmers.level3.vanishingboard;

/**
 * 프로그래머스 레벨 3 - 사라지는 발판
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2}));
    }
}

class Solution {

    private int[][] board;
    private int[] dirX = {-1, 0, 1, 0}; // 상, 좌, 하, 우
    private int[] dirY = {0, -1, 0, 1};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;

        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }

    private int dfs(int playerX, int playerY, int opX, int opY) {
        if (board[playerX][playerY] == 0) {
            return 0;
        }

        int ret = 0;    // 현재턴
        for (int i = 0; i < 4; i++) {
            int nx = playerX + dirX[i];
            int ny = playerY + dirY[i];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 0) {
                continue;
            }
            board[playerX][playerY] = 0;
            int val = dfs(opX, opY, nx, ny)+1;  // 상대방 움직이고 난 후 턴 수
            board[playerX][playerY] = 1;

            if(ret % 2 == 0 && val % 2 == 1) {
                ret = val;
            } else if(ret % 2 == 0 && val % 2 == 0) {   // 졌을 때
                ret = Math.max(ret, val);    // 최대 턴
            } else if(ret % 2 == 1 && val % 2 == 1) {   // 이겼을 때
                ret = Math.min(ret, val);    // 최소 턴
            }
        }
        return ret;
    }
}