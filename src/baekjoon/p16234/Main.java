package baekjoon.p16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0, 0, -1, 1}; //우,좌,상,하
    static int[] dy = new int[]{1, -1, 0, 0};
    static int N;
    static int L;
    static int R;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    private static int solve() {
        int days = 0;
        while (true) {
            boolean hasChanged = false;
            boolean[][] used = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!used[i][j]) {
                        Queue<Pos> q = new LinkedList<>();
                        Set<Pos> set = new HashSet<>();
                        q.add(new Pos(i, j));
                        set.add(new Pos(i, j));
                        used[i][j] = true;
                        int popCnt = A[i][j];
                        while (!q.isEmpty()) {
                            Pos poll = q.poll();
                            int value = A[poll.x][poll.y];
                            for (int k = 0; k < 4; k++) {
                                int newX = poll.x + dx[k];
                                int newY = poll.y + dy[k];
                                if (0 <= newX && newX < N && 0 <= newY && newY < N && inBetweenLR(value, newX, newY) && !used[newX][newY]) {
                                    popCnt += A[newX][newY];
                                    q.add(new Pos(newX, newY));
                                    set.add(new Pos(newX, newY));
                                    used[newX][newY] = true;
                                }
                            }
                        }
                        if (set.size() >= 2) {
                            hasChanged = true;
                        }
                        int popAvg = popCnt / set.size();
                        for (Pos pos : set) {
                            A[pos.x][pos.y] = popAvg;
                        }
                    }
                }
            }
            if(hasChanged==false)
                break;
            days++;
        }
        return days;
    }

    private static boolean inBetweenLR(int value, int i, int j) {
        int gap = Math.abs(value - A[i][j]);
        if (L <= gap && gap <= R) {
            return true;
        }
        return false;
    }

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(x + y);
        }

        @Override
        public boolean equals(Object obj) {
            Pos newPos = (Pos) obj;
            if (this.x == newPos.x && this.y == newPos.y) {
                return true;
            }
            return false;
        }
    }
}
