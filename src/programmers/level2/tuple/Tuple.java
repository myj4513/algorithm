package programmers.level2.tuple;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution("{{2},{2,2},{2,2,2},{2,2,2,2}}");
        System.out.println(Arrays.toString(result));
    }
}


/* 중복 원소가 있다는 가정의 풀이
class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] split = s.split("\\},\\{");
        Arrays.sort(split, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int[] answer = new int[split.length];
        Map<Integer, Integer> forNextMap = new HashMap<>();
        Map<Integer, Integer> forThisMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            StringTokenizer st = new StringTokenizer(split[i], ",");
            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());

                if (forThisMap.get(n) == null || forThisMap.get(n) == 0) {
                    answer[i] = n;
                }else{
                    forThisMap.put(n, forThisMap.get(n) - 1);
                }

                if(forNextMap.get(n)==null){
                    forNextMap.put(n,1);
                } else{
                    forNextMap.put(n, forNextMap.get(n) + 1);
                }
            }
            forThisMap = forNextMap;
            forNextMap = new HashMap<>();
        }

        return answer;
    }
}*/

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String s1 : arr) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}