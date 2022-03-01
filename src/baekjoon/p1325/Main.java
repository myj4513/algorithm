package baekjoon.p1325;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] cnt;
    static List<List<Integer>> graph;
    static int pos = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cnt = new int[N];
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            graph.get(to).add(from);
        }

        for (int i = 0; i < N; i++) {
            dps(i, new boolean[N]);
            pos++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(cnt[i], max);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(cnt[i] == max) sb.append(i + 1).append(" ");
        }
        System.out.println(sb);
    }

    private static void dps(int idx, boolean[] visited) {
        visited[idx] = true;
        List<Integer> list = graph.get(idx);
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                cnt[pos]++;
                dps(list.get(i), visited);
            }

        }
    }
}
