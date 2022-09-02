package programmers.level3.makeall0;

import java.util.ArrayList;

/**
 * 프로그래머스 레벨 3 - 모두 0으로 만들기
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    }
}

class Solution {
    long[] long_a;
    ArrayList<Integer>[] children;
    private long answer = 0;
    private boolean[] visited;

    public long solution(int[] a, int[][] edges) {
        long sum = 0;
        visited = new boolean[a.length];
        long_a = new long[a.length];
        children = new ArrayList[a.length];
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            children[i] = new ArrayList<>();
            long_a[i] = a[i];
        }
        if (sum != 0) return -1;
        for (int i = 0; i < edges.length; i++) {
            children[edges[i][0]].add(edges[i][1]);
            children[edges[i][1]].add(edges[i][0]);
        }
        dfs(0);
        return answer;
    }

    private long dfs(int v) {
        this.visited[v] = true;
        for (int i = 0; i < children[v].size(); i++) {
            int next = children[v].get(i);
            if (!visited[next]) {
                long_a[v] += dfs(next);
            }
        }
        this.answer += Math.abs(long_a[v]);
        return long_a[v];
    }
}
