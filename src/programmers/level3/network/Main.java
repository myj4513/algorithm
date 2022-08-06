package programmers.level3.network;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}

class Solution {
    public int solution(int n, int[][] computers) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = graph.get(i);
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1)
                    list.add(j);
            }
        }
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    if (visited[poll]) continue;
                    visited[poll] = true;
                    for (Integer node : graph.get(poll)) {
                        queue.add(node);
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}
