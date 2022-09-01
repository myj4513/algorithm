package programmers.level2.binaryconverter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("110010101001")));
    }
}

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int cnt0 = 0;
        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='0') cnt0++;
            }
            s = s.replaceAll("0", "");
            s = Integer.toString(s.length(),2);
            cnt++;
        }
        return new int[]{cnt, cnt0};
    }
}