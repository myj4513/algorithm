package programmers.level2.judge1015;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            String s = scanner.nextLine();
            Stack<Character> stack = new Stack<>();

            for(int j=0;j<s.length();j++){
                if(stack.isEmpty()){
                    stack.add(s.charAt(j));
                }
                else{
                    char c = s.charAt(j);
                    if("{([".contains(String.valueOf(c))) stack.add(c);
                    else{
                        if(c=='}' && stack.peek()=='{') stack.pop();
                        else if(c==')' && stack.peek()=='(') stack.pop();
                        else if(c==']' && stack.peek()=='[') stack.pop();
                        else stack.add(c);
                    }
                }
            }
            if(stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
