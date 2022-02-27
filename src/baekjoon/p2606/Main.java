package baekjoon.p2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Set<Integer> set = new HashSet<>();
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        solve(q, new boolean[N]);

        System.out.println(set.size());
    }

    private static void solve(Queue<Integer> q, boolean[] visited) {
        Integer poll = q.poll();
        visited[poll] = true;

        List<Integer> list = graph.get(poll);
        for (int i = 0; i < list.size(); i++) {
            if(visited[list.get(i)]) continue;
            set.add(list.get(i));
            q.add(list.get(i));
            solve(q, visited);
        }
    }
}
