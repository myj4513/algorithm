package programmers.level3.sheepwolf;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 레벨 3 - 양과 늑대
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));
    }
}

class Solution {
    private int[] info;
    private List<Integer>[] childs;
    private int maxSheepCnt = 0;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        childs = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) {
            childs[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            childs[edges[i][0]].add(edges[i][1]);
        }
        dfs(0,0,0,List.of(0));

        return maxSheepCnt;
    }

    private void dfs(int idx, int sheepCnt, int wolfCnt, List<Integer> nextPos) {
        if (info[idx] == 0) {
            sheepCnt++;
        } else {
            wolfCnt++;
        }
        if (wolfCnt >= sheepCnt) {
            return;
        }

        maxSheepCnt = Math.max(maxSheepCnt, sheepCnt);

        List<Integer> newNextPos = new ArrayList<>();
        newNextPos.addAll(nextPos);
        newNextPos.remove(Integer.valueOf(idx));
        for (int i : childs[idx]) {
            newNextPos.add(i);
        }

        for (int i : newNextPos) {
            dfs(i, sheepCnt, wolfCnt, newNextPos);
        }
    }
}