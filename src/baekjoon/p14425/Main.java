package baekjoon.p14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Set<String> S = new HashSet<>();

        int answer = 0;

        for(int i=0;i<M;i++){
            S.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            if (S.contains(br.readLine())) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
