package baekjoon.p4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        StringBuilder sb = new StringBuilder();
        while (!(str = br.readLine()).equals(".")) {
            Stack<Character> s = new Stack<>();
            boolean isAble = true;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '[' || ch == '{' || ch == '(') {
                    s.push(ch);
                } else if(ch == ']'){
                    if(s.isEmpty() || s.pop() != '[') {
                        isAble = false;
                        break;
                    }
                } else if(ch == '}'){
                    if(s.isEmpty() || s.pop() != '{') {
                        isAble = false;
                        break;
                    }
                } else if(ch == ')'){
                    if(s.isEmpty() || s.pop() != '(') {
                        isAble = false;
                        break;
                    }
                }
            }
            if(s.size() !=0) isAble = false;

            if (isAble) {
                sb.append("yes");
            } else
                sb.append("no");
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
