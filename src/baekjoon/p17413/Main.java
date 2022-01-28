package baekjoon.p17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Character> stack;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String str = br.readLine();
        stack = new Stack<>();

        int pos = 0;
        while (true) {
            if (pos >= str.length()) {
                clearStack();
                break;
            }
            char ch = str.charAt(pos);

            if (ch == '<') {
                clearStack();
                sb.append(ch);
                char c = str.charAt(++pos);
                while (c != '>') {
                    sb.append(c);
                    c = str.charAt(++pos);
                }
                sb.append(c);
            } else if (ch == ' ') {
                clearStack();
                sb.append(' ');
            } else {
                stack.add(ch);
            }
            pos++;
        }
        System.out.println(sb);
    }

    public static void clearStack() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        stack.clear();
    }
}
