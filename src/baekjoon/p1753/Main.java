package baekjoon.p1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine()) - 1;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, value));
        }
        int[] dp = new int[V];
        Arrays.fill(dp, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

        pq.add(new Node(start, 0));
        dp[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (dp[curNode.idx] < curNode.value) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);
                if (dp[nextNode.idx] > curNode.value + nextNode.value) {
                    dp[nextNode.idx] = curNode.value + nextNode.value;
                    pq.add(new Node(nextNode.idx, dp[nextNode.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(dp[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
