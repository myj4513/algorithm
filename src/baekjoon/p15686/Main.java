package baekjoon.p15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Chicken> chickenList;
    static int[][] city;
    static int N;
    static int M;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        chickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int category = Integer.parseInt(st.nextToken());
                if (category == 2) {
                    chickenList.add(new Chicken(i, j));
                }
                city[i][j] = category;
            }
        }

        solve(0, 0, new ArrayList<>());
        System.out.println(MIN);

    }

    private static void solve(int idx, int cnt, List<Chicken> list) {
        if (idx == chickenList.size()) {
            if (cnt == M) {
                int length = getChickenDistance(list);
                MIN = length < MIN ? length : MIN;
            }
            return;
        }

        solve(idx + 1, cnt, list);
        Chicken chicken = chickenList.get(idx);
        list.add(chicken);
        solve(idx + 1, cnt + 1, list);
        list.remove(chicken);
    }

    private static int getChickenDistance(List<Chicken> list) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    int min = 10000;
                    for (int k = 0; k < list.size(); k++) {
                        Chicken chicken = list.get(k);
                        int distance = Math.abs(i - chicken.r) + Math.abs(j - chicken.c);
                        min = min > distance ? distance : min;
                    }
                    total += min;
                }
            }
        }
        return total;
    }

    static class Chicken {
        int r;
        int c;

        public Chicken(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
