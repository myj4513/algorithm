package programmers.skillchecktest.level2.problem2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("{{2,1},{2,1,3},{2,1,3,4},{2}}")));
    }
}

class Solution {
    public int[] solution(String s) {
        String[] split = s.substring(2, s.length() - 2).split("}.\\{");
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Set<String> set = new HashSet<>();
        int[] answer = new int[split.length];
        for (int i = 0; i < split.length;i++) {
            String[] nums = split[i].split(",");
            for (String num : nums) {
                if (!set.contains(num)) {
                    set.add(num);
                    answer[i] = Integer.parseInt(num);
                }
            }
        }
        return answer;
    }
}