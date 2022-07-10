package programmers.level1.hashardnumber;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(131));
    }
}

class Solution {
    public boolean solution(int x) {
        int tmp = x;
        int sum = 0;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }

        return x % sum == 0;
    }
}
