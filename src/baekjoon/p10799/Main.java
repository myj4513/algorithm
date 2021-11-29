package baekjoon.p10799;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        input = input.replaceAll("\\(\\)","|");

        int fragment = 0;

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if(c=='('){
                stack.push(c);
            }
            else if(c==')'){
                fragment++;
                stack.pop();
            }
            else{
                fragment += stack.size();
            }
        }
        System.out.println(fragment);
    }
}
