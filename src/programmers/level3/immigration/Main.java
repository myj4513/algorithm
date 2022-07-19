package programmers.level3.immigration;

/**
 * 프로그래머스 레벨 3 - 입국심사
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, new int[]{7, 10}));
    }
}

class Solution {
    public long solution(int n, int[] times) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < times.length; i++) {
            max = Math.max(max, times[i]);
        }
        long start = 0;
        long end = max * n;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long processN = 0;
            for (int i = 0; i < times.length; i++) {
                processN += mid / times[i];
            }
            if (processN >= n) { //해당 시간동안 처리한 사람이 목표보다 많다 -> 시간이 충분하니 줄여도 된다.
                answer = mid;
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}