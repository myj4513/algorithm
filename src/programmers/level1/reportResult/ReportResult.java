package programmers.level1.reportResult;

import java.util.*;

public class ReportResult {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);

        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Arrays.fill(answer, 0);

        Map<String, Set<String>> reportMap = new LinkedHashMap<>();
        Map<String, Integer> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
            resultMap.put(id_list[i], 0);
        }

        StringTokenizer st = null;
        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            Set<String> set = reportMap.get(to);
            set.add(from);
            reportMap.put(to, set);
        }
        for (String s : reportMap.keySet()) {
            if (reportMap.get(s).size() >= k) {
                for(String r : reportMap.get(s)){
                    resultMap.put(r, resultMap.get(r)+1);
                }
            }
        }

        int i=0;
        for (Integer integer : resultMap.values()) {
            answer[i++] = integer;
        }
        return answer;
    }
}