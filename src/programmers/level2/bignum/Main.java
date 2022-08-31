package programmers.level2.bignum;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1924", 2));
    }
}

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        int beginIdx = 0;
        for(int i=k;i<number.length();i++){
            int max = -1;
            int maxIdx = -1;
            for (int j = beginIdx; j <= i; j++) {
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    maxIdx = j;
                }
            }
            sb.append(max);
            beginIdx = maxIdx+1;
        }

        return sb.toString();
    }
}