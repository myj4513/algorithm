package programmers.level3.crossingstone;

/**
 * 프로그래머스 레벨 3 - 징검다리 건너기
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}

class Solution {
    private int[] stones;
    public int solution(int[] stones, int k) {
        this.stones = stones;
        int start = 0;
        int end = Integer.MAX_VALUE;
        int answer = 0;
        while(start<=end) {
            int mid = (start + end) / 2;
            if (check(k, mid)) {
                answer = mid;
                start = mid+1;
            } else {
                end = mid -1;
            }
        }
        return answer;
    }

    private boolean check(int k, int mid) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid)
                count++;
            else
                count = 0;
            if (count >= k) {
                return false;
            }
        }
        return true;
    }
}