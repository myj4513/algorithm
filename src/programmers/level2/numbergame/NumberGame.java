package programmers.level2.numbergame;

import java.util.Locale;

public class NumberGame {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution(16, 16, 2, 2);
        System.out.println("answer = " + answer);
    }
}

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num =0;
        String numString ="";
        while(t>0){

            if(numString.length()>m){
                answer+= numString.charAt(p-1);
                t--;
                numString = numString.substring(m);
            }
            else{
                numString += Integer.toString(num, n);
                num++;
            }
        }

        return answer.toUpperCase(Locale.ROOT);
    }
}