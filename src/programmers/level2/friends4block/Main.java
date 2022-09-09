package programmers.level2.friends4block;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }
}

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        boolean has4Block = true;
        while (has4Block) {
            has4Block = false;
            List<Pos> list = new ArrayList<>();
            //터지는 부분 체크
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char target = map[i][j];
                    if (target != '.' && target == map[i + 1][j] && target == map[i][j + 1] && target == map[i + 1][j + 1]) {
                        list.add(new Pos(i, j));
                        has4Block = true;
                    }
                }
            }

            //터지는 부분 지우기
            for (Pos pos : list) {
                int r = pos.r;
                int c = pos.c;
                for (int i = r; i < r + 2; i++) {
                    for (int j = c; j < c + 2; j++) {
                        map[i][j] = '.';
                    }
                }
            }

            //빈공간 밑으로 내리기
            for (int c = 0; c < n; c++) {
                for (int r = m - 1; r >= 0; r--) {
                    if (map[r][c] == '.') {
                        for (int t = r - 1; t >= 0; t--) {
                            if (map[t][c] != '.') {
                                map[r][c] = map[t][c];
                                map[t][c] = '.';
                                break;
                            }
                        }
                    }
                }
            }

        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='.') answer++;
            }
        }
        return answer;
    }

    class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
