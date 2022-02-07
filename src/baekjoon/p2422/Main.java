package baekjoon.p2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 1 || N == 2) {
            System.out.println(0);
            return;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > b) {
                int tmp = b;
                b = a;
                a = tmp;
            }
            List<Integer> list = map.get(a);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(b);
            map.put(a, list);
        }

        Set<Comb> combSet = new HashSet<>();

        for (Integer first : map.keySet()) {
            List<Integer> list = map.get(first);
            for (Integer second : list) {
                for (int i = 1; i <= N; i++) {
                    if (i != first && i != second) {
                        if (i < first)
                            combSet.add(new Comb(i, first, second));
                        else if (i > first && i < second)
                            combSet.add(new Comb(first, i, second));
                        else if (i > second)
                            combSet.add(new Comb(first, second, i));
                    }
                }
            }
        }

        int total = N * (N - 1) * (N - 2) / 6;
        System.out.println(total - combSet.size());
    }

    static class Comb {
        int a;
        int b;
        int c;

        public Comb(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            Comb c = (Comb) obj;
            if (c.a == this.a && c.b == this.b && c.c == this.c) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }
}
