package programmers.skillchecktest.level4.problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 프로그래머스 레벨 4 - 동굴 탐험
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(9, new int[][]{{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}},
                new int[][]{{8,5},{6,7},{4,1}}));
    }
}

class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        List<List<Integer>> adjList = new ArrayList<>(); //인접 행렬 생성

        for (int i = 0; i < n; i++) { // 인접 행렬 초기화
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < path.length; i++) {  //인접 행렬 채우기
            adjList.get(path[i][0]).add(path[i][1]);
            adjList.get(path[i][1]).add(path[i][0]);
        }

        int[] before = new int[n]; //이전에 방문해야 하는 노드
        for (int i = 0; i < order.length; i++) {
            before[order[i][1]] = order[i][0];
        }
        if(before[0]!=0) return false;

        boolean[] visited = new boolean[n];
        int[] save = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        for (int next : adjList.get(0)) {
            queue.add(next);
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (visited[poll]) continue;
            if (!visited[before[poll]]) {
                save[before[poll]] = poll;
                continue;
            }
            visited[poll] = true;
            for (int next : adjList.get(poll)) {
                queue.add(next);
            }
            queue.add(save[poll]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}