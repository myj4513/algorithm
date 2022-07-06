package programmers.level1.collatz;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(626331));
    }
}

class Solution {
    public int solution(int num) {
        long n = num;
        int cnt = 0;
        while (cnt < 500) {
            if (n == 1) return cnt;
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
            cnt++;
        }
        return cnt==500?-1:cnt;
    }
}
