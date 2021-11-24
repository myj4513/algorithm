package baekjoon.p1874;

import java.util.Scanner;
import java.util.Stack;

public class P1874 {

    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();

        int index = 1;
        for(int i=0;i<N;i++){
            int n = Integer.parseInt(scanner.nextLine());
            if(n>=index){
                while(n>=index){
                    s.push(index++);
                    sb.append("+").append("\n");
                }
            }
            else if(n!=s.peek()){
                System.out.println("NO");
                return;
            }
            s.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }

}
