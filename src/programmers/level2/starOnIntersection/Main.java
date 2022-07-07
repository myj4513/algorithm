package programmers.level2.starOnIntersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] result = solution.solution(new int[][]{{0, 1, -1}, {1, 0, -1},{1, 0, 1}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

class Solution {
    private int maxX = Integer.MIN_VALUE;
    private int maxY = Integer.MIN_VALUE;
    private int minX = Integer.MAX_VALUE;
    private int minY = Integer.MAX_VALUE;

    public String[] solution(int[][] line) {
        Set<Pos> set = new HashSet<>();
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Pos intersection = getIntersection(line[i], line[j]);
                if (intersection != null)
                    set.add(intersection);
            }
        }
        char[][] map = new char[maxY - minY + 1][maxX - minX + 1];
        for (char[] m : map) {
            Arrays.fill(m, '.');
        }
        for (Pos pos : set) {
            map[pos.y-minY][pos.x-minX] ='*';
        }
        String[] answer = new String[map.length];
        int j = 0;
        for (int i = map.length-1; i >=0; i--) {
            answer[j++] = String.valueOf(map[i]);
        }
        return answer;
    }

    private Pos getIntersection(int[] l1, int[] l2) {
        long x0 = ((long)l1[1] * l2[2] - l1[2] * l2[1]);
        long y0 = ((long)l1[2] * l2[0] - l1[0] * l2[2]);
        long divider = ((long)l1[0] * l2[1] - l1[1] * l2[0]);
        if(divider==0) return null;
        if (x0 % divider != 0 || y0 % divider != 0) return null;
        int x = (int)(x0 / divider), y = (int)(y0 / divider);
        maxX = Math.max(x, maxX);
        maxY = Math.max(y, maxY);
        minX = Math.min(x, minX);
        minY = Math.min(y, minY);
        return new Pos(x, y);
    }

    class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
