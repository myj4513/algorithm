package baekjoon.p18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            graph.get(from).add(new Node(to, 1));
        }
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.add(new Node(X, 0));
        distance[X] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (distance[curNode.idx] < curNode.cost) {
                continue;
            }
            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);
                if (distance[nextNode.idx] > curNode.cost + nextNode.cost) {
                    distance[nextNode.idx] = curNode.cost + nextNode.cost;
                    pq.offer(new Node(nextNode.idx, distance[nextNode.idx]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean hasResult = false;
        for (int i = 0; i < N; i++) {
            if (distance[i] == K) {
                hasResult = true;
                sb.append(i + 1 + "\n");
            }
        }
        if (hasResult) {
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }
}
