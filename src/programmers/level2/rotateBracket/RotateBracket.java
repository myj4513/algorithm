package programmers.level2.rotateBracket;

import java.util.Stack;

public class RotateBracket {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution("{");
        System.out.println(answer);
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++){
            boolean check = true;
            s= s.substring(1)+s.charAt(0);
            Stack<Character> stack = new Stack<>();
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                if(c=='{' || c=='[' || c=='(')
                    stack.add(c);
                else{
                    if(!stack.isEmpty()){
                        if(stack.peek()=='{' && c=='}' || stack.peek()=='[' && c==']' || stack.peek()=='(' && c==')')
                            stack.pop();
                    }
                    else {
                        check = false;
                        break;
                    }
                }
            }
            if(check && stack.isEmpty())
                answer++;
        }

        return answer;
    }
}