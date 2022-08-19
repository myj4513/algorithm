package programmers.level3.itempickup;

/**
 *  프로그래머스 레벨 3 - 아이템 줍기
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7));
//                System.out.println(new Solution().solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}},

    }
}

class Solution {
    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    int itemX;
    int itemY;
    int min = Integer.MAX_VALUE;
    private int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //상, 우 ,좌, 하

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        this.itemX = itemX * 2;
        this.itemY = itemY * 2;
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            for (int r = y1; r <= y2; r++) {
                for (int c = x1; c <= x2; c++) {
                    map[r][c] = 1;
                }
            }
        }
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            for (int r = y1 + 1; r <= y2 - 1; r++) {
                for (int c = x1 + 1; c <= x2 - 1; c++) {
                    map[r][c] = 0;
                }
            }
        }
        bfs(characterX * 2, characterY * 2, 0);
        return min / 2;
    }

    private void bfs(int x, int y, int cnt) {
        if (x == itemX && y == itemY) {
            min = Math.min(cnt, min);
            return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][1];
            int nextY = y + dir[i][0];
            if (!visited[nextY][nextX] && map[nextY][nextX] == 1) {
                bfs(nextX, nextY, cnt + 1);
            }
        }
    }
}
