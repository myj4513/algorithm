package baekjoon.p1969;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] dnas = new String[N];

        int hammingDistance = 0;

        for (int i = 0; i < N; i++) {
            dnas[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                char ch = dnas[j].charAt(i);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            char maxChar = ' ';
            int max = -1;
            for (char ch : map.keySet()) {
                if (map.get(ch) == max) {
                    maxChar = (ch > maxChar) ? maxChar : ch;
                } else if(map.get(ch) > max){
                    maxChar = ch;
                    max = map.get(ch);
                }
            }
            sb.append(maxChar);
            hammingDistance += (N - max);
        }
        System.out.println(sb);
        System.out.println(hammingDistance);
    }
}