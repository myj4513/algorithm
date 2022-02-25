package programmers.level2.numberExpression;

public class NumberExpression {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(15);
        System.out.println("answer = " + answer);
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==1) return 1;
        for(int i=1;i<=n/2;i++){
            int sum =0;
            int num =i;
            while(sum<n){
                sum+=num;
                if(sum==n){
                    answer++;
                    break;
                }
                num++;
            }
        }
        return answer+1;
    }
}