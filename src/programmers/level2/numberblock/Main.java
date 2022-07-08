package programmers.level2.numberblock;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(1, 10)));
    }
}

class Solution {
    public int[] solution(long begin, long end) {
        int beginInt = (int) begin;
        int endInt = (int) end;
        int[] answer = new int[endInt - beginInt + 1];
        for (int i = beginInt; i <= endInt; i++) {
            answer[i-beginInt] = getMaxDivisor(i);
        }
        if (begin == 1) answer[0] = 0;
        return answer;
    }

    int getMaxDivisor(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0 && n / i <= 10000000)
                return n / i;
        }
        return 1;
    }
}
