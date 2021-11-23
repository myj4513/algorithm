package baekjoon.p2164;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        Deque<Integer> dq = new LinkedList<>();
        for(int i=1;i<=N;i++){
            dq.addLast(i);
        }
        while(dq.size()>1){
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }
        System.out.println(dq.pop());
    }
}
