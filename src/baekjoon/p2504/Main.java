package baekjoon.p2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        Stack<String> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            String c = String.valueOf(str.charAt(i));
            if(Character.isDigit(c.charAt(0))){
                while(Character.isDigit(str.charAt(i+1))){
                    c+=str.charAt(++i);
                }
            }

            int tmp = 0;
            if (c.equals("(") || c.equals("[")) {
                stack.push(c);
            }
            else if (c.equals(")")) {
                if(stack.isEmpty()){
                    System.out.println(0);
                    return;
                }
                while (!stack.peek().equals("(")) {
                    String pop = stack.pop();
                    if (pop.equals("[") || stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    } else
                        tmp += Integer.parseInt(pop);
                }
                stack.pop();
                if (tmp == 0) {
                    stack.push("2");
                } else
                    stack.push(String.valueOf(2 * tmp));
            } else if (c.equals("]")) {
                if(stack.isEmpty()){
                    System.out.println(0);
                    return;
                }
                while (!stack.peek().equals("[")) {
                    String pop = stack.pop();
                    if (pop.equals("(") || stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    } else
                        tmp += Integer.parseInt(pop);
                }
                stack.pop();
                if (tmp == 0) {
                    stack.push("3");
                } else
                    stack.push(String.valueOf(3 * tmp));
            } else
                stack.add(c);
        }

        int result = 0;

        while(!stack.isEmpty()){
            try {
                result += Integer.parseInt(stack.pop());
            } catch (Exception e) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(result);

    }
}
