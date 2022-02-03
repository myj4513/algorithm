package baekjoon.p20207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] calendar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());

        calendar = new boolean[N+1][365 + 1];

        class Pair implements Comparable<Pair>{
            int S;
            int E;

            public Pair(int s, int e) {
                S = s;
                E = e;
            }

            @Override
            public int compareTo(Pair o) {
                if (S == o.S) {
                    return o.E - E;
                }
                return S - o.S;
            }
        }
        List<Pair> list = new ArrayList<>();
        for(int a=0;a<N;a++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list.add(new Pair(S, E));
        }
        Collections.sort(list);
        for (int k = 0; k < N; k++) {
            Pair pair = list.get(k);
            int i = 1;
            while (true) {
                boolean isEmpty = true;
                for (int j = pair.S; j <= pair.E; j++) {
                    if (calendar[i][j]) {
                        i++;
                        isEmpty = false;
                        break;
                    }
                }
                if (isEmpty) {
                    for (int j = pair.S; j <= pair.E; j++) {
                        calendar[i][j] = true;
                    }
                    i=1;
                    break;
                }
            }
        }

        int[] cnt = new int[366];
        for (int i = 1; i < 366; i++) {
            int max = 0;
            for (int j = 1; j <= N; j++) {
                if (calendar[j][i]) {
                    max = j;
                }
            }
            cnt[i] = max;
        }

        int area = 0;
        int max = 0;
        int length = 0;
        for (int i = 1; i < 366; i++) {
            if (cnt[i] != 0) {
                if (max < cnt[i]) {
                    max = cnt[i];
                }
                length++;

            } else {
                area += max * length;
                max = 0;
                length = 0;
            }
        }
        area += max * length;
        System.out.println(area);
    }
}

