package codility.easy.p2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2100000000, -2100000000}));
    }
}

class Solution {
    public int solution(int[] A) {
        if (A.length == 1) return -2;
        Arrays.sort(A);
        long minGap = Long.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            long gap = 0L + A[i + 1] - A[i];
            minGap = Math.min(minGap, gap);
        }
        return minGap > 100000000 ? -1 : (int) minGap;
    }
}
