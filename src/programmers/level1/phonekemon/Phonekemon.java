package programmers.level1.phonekemon;

import java.util.Arrays;

public class Phonekemon {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{1,2,3,4});
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[] nums){
        int answer = (int)Arrays.stream(nums).distinct().count();
        return Math.min(answer, nums.length/2);
    }
}