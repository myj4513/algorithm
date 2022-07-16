package programmers.level3.farthestnode;

/**
 * 프로그래머스 레벨 3 - 가장 먼 노드
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        int[] result = bfs(n, graph);
        int max = -1;
        int maxCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (result[i] > max) {
                max = result[i];
                maxCnt = 1;
            } else if (result[i] == max) {
                maxCnt++;
            }
        }
        return maxCnt;
    }

    private int[] bfs(int n, List<List<Integer>> graph) {
        int[] count = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visited[poll] = true;
            for (int next : graph.get(poll)) {
                if (!visited[next]) {
                    count[next] = count[poll] + 1;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return count;
    }
}

