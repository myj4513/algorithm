package baekjoon.p2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        Stack<Character> stack = new Stack<>();

        int mul = 1;
        int answer = 0;

        boolean flag = true;

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(c);
                mul *= 2;
            }
            else if (c == '[') {
                stack.push(c);
                mul *= 3;
            }
            else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        flag = false;
                        break;
                    }
                    if(str.charAt(i - 1) == '(')
                        answer += mul;
                    mul/=2;
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        flag = false;
                        break;
                    }
                    if(str.charAt(i - 1) == '[')
                        answer += mul;
                    mul/=3;
                }
            }
        }
        if (!stack.isEmpty() || !flag) {
            System.out.println(0);
            return;
        }
        System.out.println(answer);
    }
}
