package level2.properbracket;

import java.util.Stack;

public class ProperBracket {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean answer = s.solution("())()(()");
        System.out.println("answer = " + answer);
    }
}

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.add(s.charAt(i));
            } else{
                if(stack.isEmpty()) return false;
                if(stack.pop()==')') return false;
            }
        }

        if(!stack.isEmpty()) return false;
        return true;
    }
}