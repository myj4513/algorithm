package dartGame;

public class DartGame {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("1D2S3T*"));
    }
}

class Solution{
    public int solution(String dartResult){
        int answer = 0;
        int cur = 0;
        int prev = 0;
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);

            if('0'<=c && c<='9'){
                cur = c-'0';
                if(c=='1' && dartResult.charAt(i+1)=='0') {
                    cur = 10;
                    i++;
                }
            }
            switch(c){
                case 'D':
                    cur = (int)Math.pow(cur,2);
                    break;
                case 'T':
                    cur = (int)Math.pow(cur,3);
                    break;
                case '*':
                    if(prev != 0)
                        prev*=2;
                    cur*=2;
                    break;
                case '#':
                    cur*=-1;
            }
            if(i<dartResult.length()-1 && '0'<=dartResult.charAt(i+1) && dartResult.charAt(i+1)<='9'){
                answer += prev;
                prev = cur;
            }
        }
        answer += prev;
        answer += cur;
        return answer;
    }
}