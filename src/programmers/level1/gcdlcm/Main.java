package programmers.level1.gcdlcm;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(3, 12)));
    }
}

class Solution {
    public int[] solution(int n, int m) {
        int gcd = gcd(n,m);
        return new int[]{gcd, n*m/gcd};
    }

    private int gcd(int a, int b) {
        if(a%b==0) return b;
        return gcd(b, a % b);
    }
}