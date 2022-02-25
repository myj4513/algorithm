package programmers.level1.divisor;

public class Divisor {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(24,27);
        System.out.println(answer);
    }
}

class Solution{
    public int solution(int left, int right){
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(getDivisorNum(i)%2==0) answer+=i;
            else answer -= i;
        }
        return answer;
    }

    public int getDivisorNum(int n){
        int result =0;
        for(int i=1;i<=n;i++){
            if(n%i==0) result++;
        }
        return result;
    }
}