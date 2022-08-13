package programmers.level3.overtimerate;

/**
 * 프로그래머스 레벨 3 - 야근 지수
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[]{5,1,7}));
    }
}

class Solution {
    public long solution(int n, int[] works) {
        int start = 0;
        int end = 50000;
        int answer = -1;
        int restN = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int usedN = getSum(works, mid);
            if (usedN > n) {
                start = mid + 1;
            } else {
                restN = n - usedN;
                answer = mid;
                end = mid - 1;
            }
        }
        if (answer == 0) return 0;
        long sum = 0L;
        for (int i = 0; i < works.length; i++) {
            if (works[i] < answer) {
                sum += works[i] * works[i];
                continue;
            }
            if (restN > 0) {
                sum += (answer - 1) * (answer - 1);
                restN--;
            } else {
                sum += answer * answer;
            }
        }

        return sum;
    }

    private int getSum(int[] works, int target) {
        int sum = 0;
        for (int i = 0; i < works.length; i++) {
            if (works[i] > target) {
                sum += works[i] - target;
            }
        }
        return sum;
    }
}