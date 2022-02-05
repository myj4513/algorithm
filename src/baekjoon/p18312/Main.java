package baekjoon.p18312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    String str = ""+(h < 10 ? "0" + h : h) + (m < 10 ? "0" + m : m) + (s < 10 ? "0" + s : s);
                    for (int i = 0; i < str.length(); i++) {
                        if(str.charAt(i) - 48 == K){
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
