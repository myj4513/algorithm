package programmers.level1.descOrderString;

import java.util.Arrays;

public class DescOrderString {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println((s.solution("Zbcdefg")));

    }
}

class Solution{
    public String solution(String s){
        char[] sol = s.toCharArray();
        Arrays.sort(sol);
        StringBuilder sb = new StringBuilder(String.valueOf(sol));
        return sb.reverse().toString();
    }
}

