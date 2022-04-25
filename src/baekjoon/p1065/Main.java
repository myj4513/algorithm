package baekjoon.p1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isHanNum(852);
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(isHanNum(i))
                cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isHanNum(int n) {
        String s = String.valueOf(n);
        if(s.length()<=2) return true;
        int gap = s.charAt(1) - s.charAt(0);
        for(int i=1;i<s.length()-1;i++){
            if (s.charAt(i) + gap != s.charAt(i + 1) + 0) {
                return false;
            }
        }
        return true;
    }
}
