package baekjoon.p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        Queue<PosCnt> q = new LinkedList<>();
        q.add(new PosCnt(N, 0));
        while (!q.isEmpty()) {
            PosCnt poll = q.poll();
            visited[poll.pos] = true;
            if(poll.pos==K) {
                System.out.println(poll.cnt);
                return;
            }
            if (poll.pos + 1 <= 100000 && !visited[poll.pos + 1]) {
                visited[poll.pos+1] = true;
                q.add(new PosCnt(poll.pos + 1, poll.cnt + 1));
            }
            if (poll.pos - 1 >= 0 && !visited[poll.pos - 1]) {
                visited[poll.pos-1] = true;
                q.add(new PosCnt(poll.pos - 1, poll.cnt + 1));
            }
            if (poll.pos * 2 <= 100000 && !visited[poll.pos * 2]) {
                visited[poll.pos] = true;
                q.add(new PosCnt(poll.pos * 2, poll.cnt + 1));
            }
        }
    }

    static class PosCnt{
        int pos;
        int cnt;

        public PosCnt(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
