package programmers.level3.puzzlesolving;

import java.util.*;

/**
 * 프로그래머스 레벨 3 - 퍼즐 조각 채우기 (실패)
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}}
                , new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}}));
    }
}

class Solution {
    private int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상,우,하,좌
    private List<List<int[]>> tableList = new ArrayList<>();
    private List<int[][]> tablePieceList;
    private List<List<int[]>> boardList = new ArrayList<>();
    private List<int[][]> boardPieceList;
    private int count = Integer.MIN_VALUE;

    public int solution(int[][] game_board, int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] == 1) {
                    bfs(tableList, i, j, table, 1);
                }
            }
        }
        Collections.sort(tableList, (o1, o2) -> o1.size() - o2.size());
        tablePieceList = getPieceList(tableList);

        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board.length; j++) {
                if (game_board[i][j] == 0) {
                    bfs(boardList, i, j, game_board, 1);
                }
            }
        }
        Collections.sort(boardList, (o1, o2) -> o1.size() - o2.size());
        boardPieceList = getPieceList(boardList);

        dfs(0, new boolean[tablePieceList.size()], 0);
        return count;
    }

    private void dfs(int depth, boolean[] isUsed, int cnt) {
        if (depth == boardPieceList.size()) {
            count = Math.max(count, cnt);
            return;
        }
        int[][] boardSpace = boardPieceList.get(depth);
        for (int i = 0; i < tablePieceList.size(); i++) {
            if (isUsed[i] || boardList.get(depth).size() > tableList.get(i).size()) continue;
            if (boardList.get(depth).size() == tableList.get(i).size()) {
                boolean matches = false;
                int[][] piece = tablePieceList.get(i);
                for (int r = 0; r < 4; r++) {
                    int[][] newPiece = new int[piece[0].length][piece.length];
                    for (int x = 0; x < piece[0].length; x++) {
                        for (int y = 0; y < piece.length; y++) {
                            newPiece[x][y] = piece[piece.length - y - 1][x];
                        }
                    }
                    if (pieceEquals(boardSpace, newPiece)) {
                        matches = true;
                        break;
                    }
                    piece = newPiece;
                }
                if (matches) {
                    isUsed[i] = true;
                    dfs(depth + 1, isUsed, cnt + boardList.get(depth).size());
                }
            }
            if (boardList.get(depth).size() < tableList.get(i).size()) break;
        }
        dfs(depth + 1, isUsed, cnt);
    }

    private List<int[][]> getPieceList(List<List<int[]>> list) {
        List<int[][]> result = new ArrayList<>();
        for (List<int[]> space : list) {
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (int[] pos : space) {
                minX = Math.min(minX, pos[0]);
                maxX = Math.max(maxX, pos[0]);
                minY = Math.min(minY, pos[1]);
                maxY = Math.max(maxY, pos[1]);
            }
            int[][] piece = new int[maxX - minX + 1][maxY - minY + 1];
            for (int[] pos : space) {
                piece[pos[0] - minX][pos[1] - minY] = 1;
            }
            result.add(piece);
        }
        return result;
    }

    private boolean pieceEquals(int[][] piece, int[][] boardSpace) {
        if (piece.length != boardSpace.length || piece[0].length != boardSpace[0].length) return false;
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[0].length; j++) {
                if (piece[i][j] != boardSpace[i][j]) return false;
            }
        }
        return true;
    }

    private void bfs(List<List<int[]>> tableList, int x, int y, int[][] table, int target) {
        List<int[]> puzzle = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            puzzle.add(poll);
            table[poll[0]][poll[1]] = -1;
            for (int d = 0; d < 4; d++) {
                int nextX = poll[0] + dir[d][0];
                int nextY = poll[1] + dir[d][1];
                if (check(nextX, nextY, table.length) && table[nextX][nextY] == target) {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        tableList.add(puzzle);
    }

    private boolean check(int x, int y, int size) {
        return 0 <= x && x < size && 0 <= y && y < size;
    }
}