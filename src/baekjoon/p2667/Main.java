package baekjoon.p2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static int cnt = 0;
    static List list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    cnt++;
                    int count = 0;
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i, j, 1));
                    while (!queue.isEmpty()) {
                        Node poll = queue.poll();
                        if (graph[poll.x][poll.y] == 0) continue;
                        count++;
                        graph[poll.x][poll.y] = 0;
                        for (int k = 0; k < 4; k++)
                            if (0 <= poll.x + dx[k] && poll.x + dx[k] < N && 0 <= poll.y + dy[k] && poll.y + dy[k] < N)
                                if (graph[poll.x + dx[k]][poll.y + dy[k]] == 1) {
                                    queue.add(new Node(poll.x + dx[k], poll.y + dy[k], poll.cnt + 1));
                                }
                    }
                    list.add(count);
                }
            }
        }
    }

    static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
