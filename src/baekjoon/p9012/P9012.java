package baekjoon.p9012;

import java.util.Scanner;
import java.util.Stack;

public class P9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<N;i++){
            String str = scanner.nextLine();
            Stack<Character> s = new Stack<>();
            boolean flag = true;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='('){
                    s.push(str.charAt(j));
                }
                else if(str.charAt(j)==')'){
                    if(s.isEmpty()){
                        flag=false;
                        break;
                    }
                    if(s.pop()!='('){
                        flag = false;
                        break;
                    }
                }
            }
            if(!s.isEmpty())
                flag = false;
            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
