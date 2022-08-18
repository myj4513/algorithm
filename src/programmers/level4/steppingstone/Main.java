package programmers.level4.steppingstone;

/**
 * 프로그래머스 레벨 4 - 징검다리
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
}

class Solution {
    private int [] rocks;
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        this.rocks = new int[rocks.length + 2];
        for (int i = 0; i < rocks.length; i++) {
            this.rocks[i+1] = rocks[i];
        }
        this.rocks[0] = 0;
        this.rocks[rocks.length+1] = distance;
        int answer = 0;
        int start = 1;
        int end = 1000000000;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isAvailable(mid, n)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    private boolean isAvailable(int gap, int n) {
        for (int i = 0; i < rocks.length-1; i++) {
            int base = rocks[i];
            while (i+1<rocks.length && rocks[i + 1] - base < gap) {
                if (n <= 0) {
                    return false;
                }
                n--; i++;
            }
        }
        return true;
    }
}
