package programmers.skillchecktest.level1.problem1;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(121));
    }
}

class Solution {
    public long solution(long n) {
        long sqrtLong = Math.round(Math.sqrt(n));
        if (sqrtLong * sqrtLong == n) {
            return (sqrtLong + 1) * (sqrtLong + 1);
        }
        return -1;
    }
}