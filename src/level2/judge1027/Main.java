package level2.judge1027;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            String str = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            for(int j=0;j<str.length();j++){
                if(stack.isEmpty()) stack.add(str.charAt(j));
                else{
                    if(stack.peek()==str.charAt(j)) stack.pop();
                    else stack.add(str.charAt(j));
                }
            }
            StringBuilder result = new StringBuilder();
            int size = stack.size();
            for(int j=0;j<size;j++){
                result.insert(0, stack.pop());
            }
            System.out.println(result);
        }
    }
}
