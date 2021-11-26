package baekjoon.p1935;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int[] num = new int[N];
        String line = scanner.nextLine();
        Stack<Double> stack = new Stack<>();
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(scanner.nextLine());
        }

        for(int i=0;i<line.length();i++){
            char c = line.charAt(i);
            if(Character.isAlphabetic(c)){
                stack.add((double)num[c-65]);
            }
            else{
                double num2 = stack.pop();
                double num1 = stack.pop();
                if(c=='+'){
                    stack.add(num1 + num2);
                }
                else if(c=='-'){
                    stack.add(num1-num2);
                }
                else if(c=='/'){
                    stack.add(num1/num2);
                }
                else if(c=='*'){
                    stack.add(num1*num2);
                }
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}
