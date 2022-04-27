package baekjoon.p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")){
                s.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            else if(command.equals("pop")){
                sb.append(s.isEmpty() ? -1 : s.pop());
            }
            else if(command.equals("size")){
                sb.append(s.size());
            }
            else if(command.equals("empty")){
                sb.append(s.isEmpty() ? 1 : 0);
            }
            else if(command.equals("top"))
                sb.append(s.isEmpty() ? -1 : s.peek());
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
