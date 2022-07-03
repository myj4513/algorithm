package programmers.level2.rankSearch;

import java.util.*;

public class RankSearch {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150", "- and - and - and - 1000"});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    private static Map<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for (String information : info) {
            String[] infoArray = information.split(" ");
            comb(0, "", infoArray);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        List<Integer> answer = new ArrayList<>();
        for (String singleQuery : query) {
            singleQuery = singleQuery.replaceAll(" and ", "");
            String[] s = singleQuery.split(" ");

            answer.add(map.containsKey(s[0]) ? biSearch(s[0], Integer.parseInt(s[1])) : 0);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int biSearch(String key, int target) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return list.size() - start;
    }

    private void comb(int depth, String str, String[] infoArray) {
        if (depth == 4) {
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(infoArray[4]));
            return;
        }
        comb(depth + 1, str + "-", infoArray);
        comb(depth + 1, str + infoArray[depth], infoArray);
    }
}