package baekjoon.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()) - 1;

        matrix = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(V);
        dfs(q, new boolean[N]);
        sb.append("\n");
        q = new LinkedList<>();
        q.add(V);
        bfs(q, new boolean[N]);

        System.out.println(sb);
    }

    private static void bfs(Queue<Integer> queue, boolean[] used) {
        if (queue.isEmpty()) return;
        Integer poll = queue.poll();
        if (!used[poll]) {
            sb.append(poll + 1 + " ");
            used[poll] = true;

            for (int i = 0; i < N; i++) {
                if (matrix[poll][i] == 1) {
                    if (!used[i])
                        queue.add(i);
                }
            }
        }
        bfs(queue, used);
    }

    private static void dfs(Queue<Integer> queue, boolean[] used) {
        if (queue.isEmpty()) return;
        Integer poll = queue.poll();
        if (used[poll]) return;
        sb.append(poll + 1 + " ");
        used[poll] = true;

        for (int i = 0; i < N; i++) {
            if (matrix[poll][i] == 1) {
                if (!used[i]) {
                    queue.add(i);
                    dfs(queue, used);
                }
            }
        }
    }
}
