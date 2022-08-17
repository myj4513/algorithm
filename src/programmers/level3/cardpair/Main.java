package programmers.level3.cardpair;

import java.util.*;

/**
 * 프로그래머스 레벨 3 - 카드 짝 맞추기
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
    }
}

class Solution {
    private int[][] board;
    private boolean[][] visitedBoard = new boolean[4][4];
    private Map<Integer, List<int[]>> cardMap;
    private int count = Integer.MAX_VALUE;
    private int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        cardMap = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    if (!cardMap.containsKey(board[i][j])) {
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{i,j});
                        cardMap.put(board[i][j], list);
                    } else {
                        cardMap.get(board[i][j]).add(new int[]{i, j});
                    }
                }
            }
        }

        perm(cardMap.keySet().stream().mapToInt(i->i).toArray(), new boolean[cardMap.size()], 0, 0, r,c);
        return cardMap.size() * 2 + count;
    }

    private int findCard(int startR, int startC, int targetR, int targetC) {
        boolean[][] visited = new boolean[4][4];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC, 0});
        int result = -1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curR = poll[0];
            int curC = poll[1];
            int curCnt = poll[2];
            if (visited[curR][curC]) continue;
            if (!visitedBoard[curR][curC] && curR == targetR && curC == targetC) {
                visitedBoard[curR][curC] = true;
                result = curCnt;
                break;
            }
            visited[curR][curC] = true;
            //그냥이동
            for (int i = 0; i < 4; i++) {
                int nextR = curR + dir[i][0];
                int nextC = curC + dir[i][1];
                if (0<=nextR && nextR<4 && 0<=nextC && nextC<4) {
                    queue.add(new int[]{nextR, nextC, curCnt + 1});
                }
            }
            //컨트롤이동
            for (int i = 0; i < 4; i++) {
                int currentR = curR;
                int currentC = curC;
                int nextR = currentR + dir[i][0];
                int nextC = currentC + dir[i][1];
                while (0 <= nextR && nextR < 4 && 0 <= nextC && nextC < 4) {
                    currentR = nextR;
                    currentC = nextC;
                    if (!visitedBoard[nextR][nextC] && board[nextR][nextC] != 0) {
                        break;
                    }
                    nextR += dir[i][0];
                    nextC += dir[i][1];
                }
                queue.add(new int[]{currentR, currentC, curCnt + 1});
            }
        }
        return result;
    }

    private void perm(int cardArr[], boolean[] visited, int depth, int cnt, int posX, int posY) {
        if (depth == visited.length) {
            count = Math.min(count, cnt);
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int targetCardNum = cardArr[i];
                List<int[]> targetCardPosition = cardMap.get(targetCardNum);
                int[] a = targetCardPosition.get(0);
                int[] b = targetCardPosition.get(1);
                int aCnt = findCard(posX, posY, a[0], a[1]);
                int bCnt = findCard(a[0], a[1], b[0], b[1]);
                perm(cardArr, visited, depth + 1, cnt + aCnt + bCnt, b[0], b[1]);
                visitedBoard[a[0]][a[1]] = false;
                visitedBoard[b[0]][b[1]] = false;
                aCnt = findCard(posX, posY, b[0], b[1]);
                bCnt = findCard(b[0], b[1], a[0], a[1]);
                perm(cardArr, visited, depth + 1, cnt + aCnt + bCnt, a[0], a[1]);
                visitedBoard[a[0]][a[1]] = false;
                visitedBoard[b[0]][b[1]] = false;
                visited[i] = false;
            }
        }
    }
}

