package programmers.level2.compression;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("ABABABABABABABAB")));
    }
}

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        int idx;
        for (idx = 0; idx < 26; idx++) {
            dict.put(String.valueOf((char) ('A' + idx)), idx + 1);
        }
        idx++;
        boolean isEnd = false;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < msg.length(); ++i) {
            String s = String.valueOf(msg.charAt(i));
            while (dict.containsKey(s)) {
                i++;
                if (i == msg.length()) {
                    isEnd = true;
                    break;
                }
                s += String.valueOf(msg.charAt(i));
            }
            if (isEnd) {
                answer.add(dict.get(s));
                break;
            }
            dict.put(s, idx++);
            i--;
            answer.add(dict.get(s.substring(0, s.length() - 1)));
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
