package programmers.level2.visitedLength;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("ULURRDLLU"));
    }
}

class Solution {
    private String DIR = "UDLR";
    private int[][] move = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String dirs) {
        int answer = 0;
        boolean[][] visited = new boolean[21][21];
        int x = 10;
        int y = 10;
        for (int i = 0; i < dirs.length(); i++) {
            int dir = DIR.indexOf(dirs.charAt(i));
            int nxtX = x + move[dir][0] * 2;
            int nxtY = y + move[dir][1] * 2;
            if (nxtX < 0 || nxtX > 20 || nxtY < 0 || nxtY > 20) continue;
            if (!visited[x + move[dir][0]][y + move[dir][1]]) {
                answer++;
                visited[x + move[dir][0]][y + move[dir][1]] = true;
            }
            x = nxtX;
            y = nxtY;
        }
        return answer;
    }
}