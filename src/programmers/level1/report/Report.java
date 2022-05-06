package programmers.level1.report;

import java.util.*;

public class Report {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi muzi"}, 2)));

    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCnt = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            reportCnt.put(id_list[i], 0);
        }
        for (int i = 0; i < report.length; i++) {
            Set<String> set = new HashSet();
            StringTokenizer st = new StringTokenizer(report[i]);
            while (st.hasMoreTokens()) {
                set.add(st.nextToken());
            }
            System.out.println(set);
            set.forEach(s -> reportCnt.put(s, reportCnt.get(s) + 1));

        }
        int[] answer = new int[id_list.length];

        for (int i = 0; i < report.length; i++) {
            Set<String> set = new HashSet();
            StringTokenizer st = new StringTokenizer(report[i]);
            while (st.hasMoreTokens()) {
                set.add(st.nextToken());

            }
            for (int j = 0; j < set.size(); j++) {

            }
        }
        return answer;
    }
}