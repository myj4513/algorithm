package baekjoon.p15787;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int[][] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trains = new int[N + 1][21];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    order1(i,Integer.parseInt(st.nextToken())); break;
                case 2:
                    order2(i,Integer.parseInt(st.nextToken())); break;
                case 3:
                    order3(i); break;
                case 4:
                    order4(i); break;
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            List<Integer> list = Arrays.stream(trains[i]).boxed().collect(Collectors.toList());
            set.add(list);
        }
        System.out.println(set.size());

    }

    public static void order1(int i, int x){
        trains[i][x] = 1;
    }
    public static void order2(int i, int x){
        trains[i][x] = 0;
    }
    public static void order3(int i){
        for (int j = 20; j > 1; j--) {
            trains[i][j] = trains[i][j-1];
        }
        trains[i][1] = 0;
    }
    public static void order4(int i){
        for (int j = 1; j < 20; j++) {
            trains[i][j] = trains[i][j+1];
        }
        trains[i][20] = 0;
    }
}
