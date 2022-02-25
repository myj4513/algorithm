package programmers.level2.changeBracket;

import java.util.Stack;

public class ChangeBracket {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("()))((()"));

    }
}

class Solution {
    public String solution(String p) {
        if(p.equals("")) return p;
        String u="";
        String v="";
        int bal = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(') bal++;
            else if(p.charAt(i)==')') bal--;
            if(bal==0){
                u = p.substring(0, i+1);
                v = p.substring(i+1);
                break;
            }
        }
        if(isProper(u)){
            return u+solution(v);
        }
        else{
            v = "("+solution(v)+")";
            u = u.substring(1,u.length()-1);
            StringBuilder sb = new StringBuilder();

            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='(')
                    sb.append(')');
                else
                    sb.append('(');
            }
            return v+sb.toString();
        }
    }

    public boolean isProper(String w){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<w.length();i++){
            if(w.charAt(i)=='('){
                s.add('(');
            }
            else{
                if(s.size()==0) return false;
                s.pop();
            }
        }
        return s.size()==0;
    }
}
