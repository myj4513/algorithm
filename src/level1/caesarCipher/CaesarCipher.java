package level1.caesarCipher;

public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(Character.toUpperCase(' ')+"aa");
        Solution s = new Solution();
        String answer = s.solution("Z", 3);
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String s, int n){
        String answer = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('a'<=c && c<='z'){
                c = (char)((c+n-'a')%26+'a');
            }
            else if('A'<=c && c<='Z'){
                c = (char)((c+n-'A')%26+'A');

            }
            answer += c;
        }
        return answer;
    }
}