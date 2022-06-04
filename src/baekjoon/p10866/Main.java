package baekjoon.p10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) sb.append(-1);
                else sb.append(deque.pollFirst());
                sb.append('\n');
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) sb.append(-1);
                else sb.append(deque.pollLast());
                sb.append('\n');
            } else if (command.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (command.equals("empty")) {
                if (deque.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append('\n');
            } else if (command.equals("front")) {
                if (deque.isEmpty()) sb.append(-1);
                else sb.append(deque.peekFirst());
                sb.append('\n');
            } else if (command.equals("back")) {
                if (deque.isEmpty()) sb.append(-1);
                else sb.append(deque.peekLast());
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }
}
