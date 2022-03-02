package baekjoon.p2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(cnt);
    }

    private static void bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.x + 1 == N && poll.y + 1 == M) {
                cnt = poll.cnt;
                return;
            }
            if (visited[poll.x][poll.y]) continue;
            visited[poll.x][poll.y] = true;
            for (int i = 0; i < 4; i++) {
                if (0 <= poll.x + dx[i] && poll.x + dx[i] < N && 0 <= poll.y + dy[i] && poll.y + dy[i] < M)
                    if (graph[poll.x + dx[i]][poll.y + dy[i]] == 1) {
                        queue.add(new Node(poll.x + dx[i], poll.y + dy[i], poll.cnt + 1));
                    }
            }
        }

    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
