package programmers.level1.mbti;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 레벨 1 - 성격 유형 검사
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}

class Solution {
    private int[] points = new int[]{0, 3, 2, 1, 0, 1, 2, 3};
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> mbti = new HashMap<>();
        mbti.put('A',0);
        mbti.put('N',0);
        mbti.put('C',0);
        mbti.put('F',0);
        mbti.put('M',0);
        mbti.put('J',0);
        mbti.put('R',0);
        mbti.put('T',0);
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] > 4) {
                mbti.put(survey[i].charAt(1), mbti.get(survey[i].charAt(1)) + points[choices[i]]);
            } else {
                mbti.put(survey[i].charAt(0), mbti.get(survey[i].charAt(0)) + points[choices[i]]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(mbti.get('R') >= mbti.get('T')){
            sb.append('R');
        } else
            sb.append('T');
        if(mbti.get('C') >= mbti.get('F')){
            sb.append('C');
        } else
            sb.append('F');
        if(mbti.get('J') >= mbti.get('M')){
            sb.append('J');
        } else
            sb.append('M');
        if(mbti.get('A') >= mbti.get('N')){
            sb.append('A');
        } else
            sb.append('N');
        return sb.toString();
    }
}
