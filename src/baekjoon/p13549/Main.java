package baekjoon.p13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final static int SIZE = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Node(1, 1));
        graph.get(SIZE - 1).add(new Node(SIZE - 2, 1));
        for (int i = 1; i < SIZE-1; i++) {
            List<Node> list = graph.get(i);
            list.add(new Node(i - 1, 1));
            list.add(new Node(i+1, 1));
        }
        int j = 0;
        while (j * 2 < SIZE) {
            graph.get(j).add(new Node(j*2, 0));
            j++;
        }

        int[] dp = new int[SIZE];
        Arrays.fill(dp, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dp[from] = 0;
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (dp[curNode.idx] < curNode.cost) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nextNode = graph.get(curNode.idx).get(i);
                if (dp[nextNode.idx] > curNode.cost + nextNode.cost) {
                    dp[nextNode.idx] = curNode.cost + nextNode.cost;
                    pq.add(new Node(nextNode.idx, dp[nextNode.idx]));
                }
            }
        }
        System.out.println(dp[to]);
    }

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}
