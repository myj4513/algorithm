package programmers.level2.archerycompetition;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }
}

class Solution {
    private int maxDepth;
    private int[] aInfo;
    private int maxScoreDiff = Integer.MIN_VALUE;
    private int[] maxLInfo;

    public int[] solution(int n, int[] info) {
        maxDepth = n;
        aInfo = info;
        int[] lInfo = new int[11];
        dfs(0, lInfo, -1);

        return maxScoreDiff > 0 ? maxLInfo : new int[]{-1};
    }

    private void dfs(int depth, int[] lInfo, int idx) {
        if (depth == maxDepth) {
            int lScore = 0;
            int aScore = 0;
            for (int i = 0; i <= maxDepth; i++) {
                if (aInfo[i] < lInfo[i]) {
                    lScore += 10 - i;
                } else if (aInfo[i] != 0) {
                    aScore += 10 - i;
                }
            }
            int scoreDiff = lScore - aScore;
            if (scoreDiff > maxScoreDiff) {
                maxLInfo = lInfo;
                maxScoreDiff = scoreDiff;
            } else if (scoreDiff > 0 && scoreDiff == maxScoreDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (maxLInfo[i] < lInfo[i]) {
                        maxLInfo = lInfo;
                        return;
                    } else if (maxLInfo[i] > lInfo[i]) {
                        return;
                    }
                }
            }
            return;
        }

        for (int i = idx + 1; i <= maxDepth; i++) {
            int[] nextLInfo = new int[11];
            for (int j = 0; j <= maxDepth; j++) {
                nextLInfo[j] = lInfo[j];
            }

            if (i == maxDepth) {
                nextLInfo[i] += maxDepth - depth;
                dfs(maxDepth, nextLInfo, i);
            } else if (aInfo[i] < maxDepth - depth) {
                nextLInfo[i] += aInfo[i]+1;
                dfs(depth + nextLInfo[i], nextLInfo, i);
            }
        }
    }
}
