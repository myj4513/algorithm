package baekjoon.p18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int back = -1;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                queue.add(n);
                back = n;
            } else if (command.equals("pop")) {
                if (queue.isEmpty()) sb.append(-1);
                else sb.append(queue.poll());
                sb.append('\n');
            } else if (command.equals("size")) {
                sb.append(queue.size()).append('\n');
            } else if (command.equals("empty")) {
                if (queue.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append('\n');
            } else if (command.equals("front")) {
                if (queue.isEmpty()) sb.append(-1);
                else sb.append(queue.peek());
                sb.append('\n');
            } else if (command.equals("back")) {
                if (queue.isEmpty()) sb.append(-1);
                else sb.append(back);
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }
}
