package level2.removePair;

import java.util.LinkedList;

public class RemovePair {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("abcabcbbcbabbcba"));
    }
}

class Solution{
    public int solution(String s){
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.add(s.charAt(i));
            }
            else if(s.charAt(i)==stack.getLast()){
                stack.removeLast();
            }
            else{
                stack.add(s.charAt(i));
            }
        }
        if(stack.size()==0)
            return 1;
        return 0;
    }
}