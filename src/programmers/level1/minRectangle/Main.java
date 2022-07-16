package programmers.level1.minRectangle;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }
}

class Solution {
    public int solution(int[][] sizes) {
        int size = sizes.length;
        int maxH = Integer.MIN_VALUE;
        int maxW = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            maxH = Math.max(maxH, Math.max(sizes[i][0], sizes[i][1]));
            maxW = Math.max(maxW, Math.min(sizes[i][0], sizes[i][1]));
        }
        return maxH * maxW;
    }
}
