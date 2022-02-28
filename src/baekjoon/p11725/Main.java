package baekjoon.p11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[N];
        int[] parent = new int[N];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;

            for (int i = 0; i < graph.get(poll).size(); i++) {
                int to = graph.get(poll).get(i);
                if (!visited[to]) {
                    parent[to] = poll+1;
                    queue.add(to);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N; i++) sb.append(parent[i]).append("\n");
        System.out.print(sb);
    }
}
