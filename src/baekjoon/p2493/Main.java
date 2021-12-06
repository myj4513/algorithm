package baekjoon.p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Pair> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        stack.push(new Pair(1, Integer.parseInt(st.nextToken())));
        sb.append("0 ");

        for(int i=2;i<=N;i++){
            int tmp = Integer.parseInt(st.nextToken());

            if (stack.peek().height > tmp) {
                stack.push(new Pair(i, tmp));
                sb.append(i-1+" ");
            } else {
                int idx = 0;
                while(true){
                    if(stack.isEmpty()){
                        break;
                    }
                    if (stack.peek().height < tmp) {
                        stack.pop();
                    } else {
                        idx = stack.peek().idx;
                        break;
                    }
                }
                sb.append(idx + " ");
                stack.push(new Pair(i, tmp));
            }
        }
        System.out.println(sb);
    }
}

class Pair{
    int idx;
    int height;

    public Pair(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}