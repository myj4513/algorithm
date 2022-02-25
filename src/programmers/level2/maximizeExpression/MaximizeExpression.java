package programmers.level2.maximizeExpression;

import java.util.LinkedList;
import java.util.List;

public class MaximizeExpression {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("50*6-3*2");
    }
}

class Solution {
    String[] perm = {"*+-", "*-+", "+*-", "+-*", "-+*", "-*+"};
    public long solution(String expression) {
        long answer = 0;
        List<String> list = new LinkedList<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='+' || c=='-' || c=='*'){
                list.add(expression.substring(0,i));
                list.add(""+c);
                expression = expression.substring(i+1);
                i=-1;
            }
        }
        list.add(expression);
        long max = Long.MIN_VALUE;
        for(int k=0;k<perm.length;k++){
            List<String> newList = new LinkedList<>(list);
            for(int j=0;j<3;j++){
                for(int i=0;i<newList.size();i++){
                    if(newList.get(i).equals(""+perm[k].charAt(j))){
                        Long l = compute(newList.get(i-1), newList.get(i+1), newList.get(i));
                        newList.remove(i-1);
                        newList.remove(i-1);
                        newList.remove(i-1);
                        newList.add(i-1,l.toString());
                        i=0;
                        System.out.println(newList);
                    }
                }
            }
            if(Math.abs(Long.parseLong(newList.get(0)))>max)
                max = Math.abs(Long.parseLong(newList.get(0)));
        }
        return max;
    }

    public Long compute(String s1, String s2, String operator){
        Long l1 = Long.parseLong(s1);
        Long l2 = Long.parseLong(s2);
        if(operator.equals("-")){
            return l1-l2;
        }
        else if(operator.equals("+")){
            return l1+l2;
        }
        else if(operator.equals("*")){
            return l1*l2;
        }
        return 0L;
    }
}