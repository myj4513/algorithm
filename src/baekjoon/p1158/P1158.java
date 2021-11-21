package baekjoon.p1158;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 백준 1158번
 * 자료구조
 * 요세푸스 문제
 */

public class P1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int K = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=K;i++){
            q.offer(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            for(int i=0;i<N-1;i++){
                q.offer(q.poll());
            }
            list.add(q.poll());
        }
        String answer = list.toString().replace('[', '<');
        answer = answer.replace(']','>');
        System.out.println(answer);
    }
}
