package programmers.level1.weirdString;

public class WeirdString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("TRY HELLO WORLD"));
    }
}

class Solution {
    public String solution(String s) {
        String answer = "";

        int index = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' ')
                index = 0;
            else {
                if (index++ % 2 == 0) {
                    c = Character.toUpperCase(c);
                } else
                    c = Character.toLowerCase(c);
            }


            answer += c;
        }

        return answer;
    }
}