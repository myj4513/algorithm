package baekjoon.p2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'c') {
                if (i + 1 < str.length() && str.charAt(i + 1) == '=') {
                    i++;
                } else if (i + 1 < str.length() && str.charAt(i + 1) == '-') {
                    i++;
                }

            } else if (ch == 'd') {
                if (i + 2 < str.length() && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
                    i += 2;
                } else if (i + 1 < str.length() && str.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (i + 1 < str.length() && ch == 'l' && str.charAt(i + 1) == 'j') {
                i++;
            } else if (i + 1 < str.length() && ch == 'n' && str.charAt(i + 1) == 'j') {
                i++;
            } else if (i + 1 < str.length() && ch == 's' && str.charAt(i + 1) == '=') {
                i++;
            } else if (i + 1 < str.length() && ch == 'z' && str.charAt(i + 1) == '=') {
                i++;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
