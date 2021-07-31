package level1.countPrimeNumber;

public class CountPrimeNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5));
    }
}

class Solution{
    public int solution(int n){
        int answer = 0;
        for(int i=2;i<=n;i++){
            boolean isPrime = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                answer++;
        }
        return answer;
    }
}