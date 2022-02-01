package baekjoon.p2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int[][] board = new int[19][19];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                int x = board[i][j];

                if (x != 0) {
                    boolean win = false;
                    //세로
                    if (i - 1 >= 0 && board[i - 1][j] == x) {}
                    else{
                        for (int k = 1; k < 5; k++) {
                            if (i - 1 >= 0 && board[i - 1][j] == x) break;
                            if (i + k < 19 && board[i + k][j] == x) {
                                win = true;
                            } else {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            if (i + 5 < 19 && board[i + 5][j] == x) {
                                win = false;
                            } else {
                                System.out.println(x + "\n" + (i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }

                    //가로
                    if (j - 1 >= 0 && board[i][j - 1] == x) {}
                    else{
                        for (int k = 1; k < 5; k++) {

                            if (j + k < 19 && board[i][j + k] == x) {
                                win = true;
                            } else {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            if (j + 5 < 19 && board[i][j + 5] == x) {
                            } else {
                                System.out.println(x + "\n" + (i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }

                    //대각선 아래
                    if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == x) {}
                    else {
                        for (int k = 1; k < 5; k++) {

                            if (i + k < 19 && j + k < 19 && board[i + k][j + k] == x) {
                                win = true;
                            } else {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            if (i + 5 < 19 && j + 5 < 19 && board[i + 5][j + 5] == x) {
                            } else {
                                System.out.println(x + "\n" + (i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }

                    //대각선 위
                    if (i + 1 < 19 && j - 1 >= 0 && board[i + 1][j - 1] == x) {}
                    else {
                        for (int k = 1; k < 5; k++) {

                            if (i - k >= 0 && j + k < 19 && board[i - k][j + k] == x) {
                                win = true;
                            } else {
                                win = false;
                                break;
                            }
                        }
                        if (win) {
                            if (i - 5 >= 0 && j + 5 < 19 && board[i - 5][j + 5] == x) {
                            } else {
                                System.out.println(x + "\n" + (i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("0");
        return;
    }
}
