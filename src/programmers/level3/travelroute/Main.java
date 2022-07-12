package programmers.level3.travelroute;

import java.util.*;

/**
 * 프로그래머스 레벨 3 - 여행경로
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}})));
    }
}

class Solution {
    private String[][] T;
    private List<String> answerList = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        T = tickets;
        dfs("ICN", 0, tickets.length, new boolean[tickets.length], "ICN");
        Collections.sort(answerList);
        return answerList.get(0).split(" ");
    }

    private void dfs(String cur, int depth, int n, boolean[] visited, String answer) {
        if (depth == n) {
            answerList.add(answer);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i] && T[i][0].equals(cur)){
                visited[i] = true;
                dfs(T[i][1], depth + 1, n, visited, answer + " " + T[i][1]);
                visited[i] = false;
            }
        }
    }
}
