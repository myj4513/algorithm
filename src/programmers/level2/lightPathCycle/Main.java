package programmers.level2.lightPathCycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"SLSR", "LLRS", "RSLR", "RRRR"})));
    }
}

class Solution {
    private static int R, C;
    private static String[] map;
    private static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상, 우, 하, 좌
    private static boolean[][][] isVisited;

    public int[] solution(String[] grid) {
        map = grid;
        R = grid.length;
        C = grid[0].length();
        isVisited = new boolean[R][C][4];

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!isVisited[i][j][k]) {
                        answer.add(light(i, j, k));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int light(int r, int c, int d) {
        int cnt = 0;
        while (true) {
            if (isVisited[r][c][d])
                break;
            cnt++;
            isVisited[r][c][d] = true;
            if (map[r].charAt(c) == 'R') {
                d = (d + 1) % 4;
            } else if (map[r].charAt(c) == 'L') {
                d = (d + 3) % 4;
            }

            r = (r + dir[d][0] + R) % R;
            c = (c + dir[d][1] + C) % C;
        }
        return cnt;
    }
}