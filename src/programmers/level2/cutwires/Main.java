package programmers.level2.cutwires;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[][]{{1,2},{2,3}}));
    }
}

class Solution {
    private int min = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) { //인접리스트 초기화
            adjList.add(new HashSet<>());
        }
        for (int i = 0; i < n - 1; i++) { //인접리스트 양방향 설정
            int s1 = wires[i][0];
            int s2 = wires[i][1];
            adjList.get(s1).add(s2);
            adjList.get(s2).add(s1);
        }

        for (int i = 0; i < n - 1; i++) { //각 wire를 하나씩 자른 경우마다 bfs로 개수 구하기
            int s1 = wires[i][0];
            int s2 = wires[i][1];
            adjList.get(s1).remove(s2);
            adjList.get(s2).remove(s1);
            boolean[] visited = new boolean[n + 1];
            int cnt1 = bfs(adjList, visited, 1, 0);
            int cnt2 = 0;
            for (int j = 2; j <= n; j++) {
                if (!visited[j]) {
                    cnt2 = bfs(adjList, visited, j, 0);
                }
            }
            min = Math.min(Math.abs(cnt1 - cnt2), min);
            adjList.get(s1).add(s2);
            adjList.get(s2).add(s1);
        }
        return min;
    }

    private int bfs(List<Set<Integer>> linkList, boolean[] visited, int start, int cnt) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            cnt++;
            for (Integer i : linkList.get(v)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return cnt;
    }
}