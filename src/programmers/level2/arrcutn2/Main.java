package programmers.level2.arrcutn2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(4,7,14)));
    }
}

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];
        for (int i = 0; i < size; i++) {
            long tmp = left + i;
            answer[i] = (int)Math.max(tmp/n, tmp%n)+1;
        }
        return answer;
    }
}