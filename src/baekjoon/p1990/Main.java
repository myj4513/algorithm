package baekjoon.p1990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[end+1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= end; i++) {
            if (!prime[i]) {
                for (int j = 2; i * j <= end; j++) {
                    prime[i*j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (!prime[i] && isPalindrome(i)) {
                sb.append(i).append('\n');
            }
        }
        sb.append(-1);
        System.out.println(sb);
    }

    private static boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if(s.charAt(start)!=s.charAt(end))return false;
            start++;
            end--;
        }
        return true;
    }
}
