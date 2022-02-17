package baekjoon.p1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N-- > 0) {
            String str = br.readLine();
            boolean[] used = new boolean[26];
            char lastChar = str.charAt(0);
            used[lastChar - 'a'] = true;
            boolean check = true;
            for (int i = 1; i < str.length(); i++) {
                char curr = str.charAt(i);
                if (curr == lastChar) {
                    continue;
                } else {
                    if (!used[curr - 'a']) {
                        used[curr - 'a'] = true;
                        lastChar = curr;
                    } else {
                        check = false;
                        break;
                    }
                }
            }
            if(check) count++;
        }
        System.out.println(count);
    }
}
