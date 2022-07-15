package programmers.level3.trackconstruction;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 레벨 3 - 경주로 건설
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
}

class Solution {
    private int[][] board;
    private int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상, 우, 하, 좌
    private int min = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        this.board = board;

        bfs();

        return min;
    }

    private void bfs() {
        int N = board.length;
        boolean[][][] visited = new boolean[N][N][4];
        int[][] minPrice = new int[N][N];
        Queue<Node> queue = new LinkedList<>();
        visited[0][0][0] = visited[0][0][1] = visited[0][0][2] = visited[0][0][3] = true;
        queue.add(new Node(0, 0, -1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.x == N - 1 && poll.y == N - 1) {
                min = Math.min(min, poll.price);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + move[i][0];
                int nextY = poll.y + move[i][1];
                if (check(nextX, nextY) && board[nextX][nextY] == 0) {
                    int price = poll.price + ((poll.direction == i || poll.direction == -1) ? 100 : 600);
                    if (price <= minPrice[nextX][nextY]) {
                        visited[nextX][nextY][i] = true;
                        minPrice[nextX][nextY] = price;
                        queue.add(new Node(nextX, nextY, i, price));
                    }
                }
            }
        }
    }

    private boolean check(int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }

    private class Node {
        int x;
        int y;
        int direction;
        int price;

        public Node(int x, int y, int direction, int price) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.price = price;
        }
    }
}
