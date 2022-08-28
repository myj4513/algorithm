package programmers.level2.fatigue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }
}

class Solution {
    private int maxCnt = Integer.MIN_VALUE;
    private int[][] staticDungeons;
    public int solution(int k, int[][] dungeons) {
        staticDungeons = dungeons;
        dfs(new boolean[dungeons.length], k, 0, 0);
        return maxCnt;
    }

    private void dfs(boolean[] visited, int fatigue, int depth, int cnt) {
        if (depth == visited.length) {
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            if(fatigue>=staticDungeons[i][0]){
                visited[i] = true;
                dfs(visited, fatigue - staticDungeons[i][1], depth + 1, cnt + 1);
                visited[i] = false;
            }
            dfs(visited, fatigue, depth+1, cnt);
        }
    }
}