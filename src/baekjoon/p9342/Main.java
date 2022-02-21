package baekjoon.p9342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String regex = "^[A-F]?A+F+C+[A-F]?$";

        while (N-- > 0) {
            String str = br.readLine();
            if (str.matches(regex)) {
                sb.append("Infected!");
            } else
                sb.append("Good");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
