package level1.centerCharacter;

public class CenterCharacter {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("abcd"));
    }
}

class Solution {
    public String solution(String s){
        String answer = "";
        if(s.length()%2==0){
            answer += s.substring(s.length()/2-1, s.length()/2+1);
        }
        else{
            answer += s.charAt(s.length()/2);
        }
        return answer;
    }
}