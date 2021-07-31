package level1.reverseLong;

import java.util.Arrays;

public class ReverseLong {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(2187841)));
    }
}

class Solution {
    public int[] solution(long n) {
        String s = ""+n;
        StringBuilder sb = new StringBuilder(""+n);
        sb = sb.reverse();
        String[] arr = sb.toString().split("");
        int[] answer = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            answer[i] = Integer.parseInt(arr[i]);
        }
        return answer;
    }
}