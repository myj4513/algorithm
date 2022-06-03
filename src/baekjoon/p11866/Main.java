package baekjoon.p11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int cnt = 1;
        while (!queue.isEmpty()) {
            if (cnt < K) {
                int tmp = queue.poll();
                queue.add(tmp);
                cnt++;
            } else {
                sb.append(queue.poll()).append(", ");
                cnt = 1;
            }
        }
        sb.replace(sb.length() - 2, sb.length(), ">");
        System.out.println(sb);
    }
}
