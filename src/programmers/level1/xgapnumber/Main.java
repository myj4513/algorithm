package programmers.level1.xgapnumber;

import java.util.Arrays;

/**
 * 프로그래머스 레벨 1 - x 만큼 간격이 있는 n개의 숫자
 */

public class Main {
    public static void main(String[] args) {
        long[] result = new Solution().solution(2, 5);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long num = x;
        for (int i = 0; i < n; i++) {
            answer[i] = num;
            num += x;
        }
        return answer;
    }
}
