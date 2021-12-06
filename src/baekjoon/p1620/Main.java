package baekjoon.p1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

        Map<String, String> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(name, String.valueOf(i));
            map.put(String.valueOf(i), name);
        }

        for(int i=0;i<M;i++){
            String findStr = br.readLine();
            try{
                Integer.parseInt(findStr);
                sb.append(map.get(findStr)+"\n");
            } catch(Exception e){
                sb.append(map.get(findStr)+"\n");
            }
        }
        System.out.println(sb);

    }
}
