package programmers.level3.bestset;

/**
 * 프로그래머스 레벨 3 - 최고의 집합
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(2, 9)));
    }
}

class Solution {
    public int[] solution(int n, int s) {
        if (s / n < 1) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        if (s % n == 0) {
            Arrays.fill(answer, s / n);
        }
        int x = s / n;
        int y = s / n + 1;
        for (int i = 1; i < n; i++) {
            if (x * i + y * (n - i) == s) {
                int idx = 0;
                for (int j = 0; j < i; j++) {
                    answer[idx++] = x;
                }
                for (int j = 0; j < n - i; j++) {
                    answer[idx++] = y;
                }
            }
        }
        return answer;
    }
}