package baekjoon.p1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < board.length(); i++) {
            if (i + 3 < board.length() && board.substring(i, i + 4).equals("XXXX")) {
                sb.append("AAAA");
                i += 3;
            } else if (i + 1 < board.length() && board.substring(i, i + 2).equals("XX")) {
                sb.append("BB");
                i += 1;
            } else if (board.charAt(i) == '.')
                sb.append(".");
            else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(sb);
    }
}
