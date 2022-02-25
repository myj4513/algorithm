package programmers.level2.tuple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Set<String> set = new HashSet<>();
        System.out.println(s.substring(1,s.length()-1));
        return answer;
    }
}