package baekjoon.p16171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (!Character.isDigit(ch))
                sb.append(ch);
        }
        System.out.println(sb.toString().contains(str) ? 1 : 0);
    }
}
