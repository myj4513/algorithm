package level2.fibonacci;

public class Fibonacci {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(10000);
        System.out.println("answer = " + answer);
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;
        if(n==0) return 0;
        if(n==1) return 1;

        for(int i=0;i<n-1;i++){
            f2 = f0+f1;
            f0 = f1%1234567;
            f1 = f2%1234567;
        }

        System.out.println("f2 = " + f2);
        return (int)(f2%1234567);
    }
}