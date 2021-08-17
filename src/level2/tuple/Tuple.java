package level2.tuple;

import java.util.Arrays;

public class Tuple {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(result));
    }
}


class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        System.out.println(s.substring(1,s.length()-1));
        return answer;
    }
}