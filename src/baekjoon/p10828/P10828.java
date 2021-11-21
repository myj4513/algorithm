package baekjoon.p10828;

import java.util.Scanner;
import java.util.Stack;

public class P10828 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        for(int i=0;i<N;i++){
            String[] str = scanner.nextLine().split(" ");
            if(str[0].equals("push")){
                s.push(Integer.parseInt(str[1]));
            }
            else if(str[0].equals("pop")){
                if(s.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(s.pop());
            }
            else if(str[0].equals("size")){
                System.out.println(s.size());
            }
            else if(str[0].equals("empty")){
                if(s.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if(str[0].equals("top"))
                if(s.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(s.peek());
        }
    }
}
