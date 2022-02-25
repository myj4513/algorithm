package programmers.level1.reverseLong2;


import java.util.*;

public class ReverseOrder2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1234567890));
    }
}

class Solution {
    public long solution(long n) {
        String[] s = (""+n).split("");
        System.out.println(Arrays.toString(s));
        Arrays.sort(s, Collections.reverseOrder());
        String aa = "";
        for(int i=0;i<s.length;i++){
            aa += s[i];
        }
        return Long.parseLong(aa);
    }
}