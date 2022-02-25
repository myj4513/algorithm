package programmers.level2.smallestNumber;

import java.util.Arrays;

public class SmallestNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4,});
        System.out.println("answer = " + answer);
    }
}

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            answer += A[i] * B[B.length - 1 - i];
        }

        return answer;
    }
}
