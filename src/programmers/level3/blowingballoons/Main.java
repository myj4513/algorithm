package programmers.level3.blowingballoons;

/**
 * 프로그래머스 레벨 3 - 풍선 터트리기
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
//        System.out.println(new Solution().solution(new int[]{9,-1,-5}));
    }
}

class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        leftMin[0] = a[0];
        rightMin[a.length - 1] = a[a.length - 1];
        int answer = 2;
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
            rightMin[a.length - i - 1] = Math.min(rightMin[a.length - i], a[a.length - i -1]);
        }
        for (int i = 1; i < a.length - 1; i++) {
            int n = a[i];
            int leftMinVal = leftMin[i - 1];
            int rightMinVal = rightMin[i + 1];
            if (n > leftMinVal && n > rightMinVal)
                continue;
            answer++;
        }
        return answer;
    }
}
