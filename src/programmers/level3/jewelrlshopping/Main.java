package programmers.level3.jewelrlshopping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 프로그래머스 레벨 3 - 보석 쇼핑
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"A", "B", "A", "A", "A", "C", "A", "B"})));
    }
}

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }

        int start = 1;
        int end = gems.length;

        int left = 0;
        int right = 0;

        Map<String, Integer> map = new HashMap<>();

        while (left <= gems.length && right <= gems.length) {
            if (map.size() == set.size()) {
                String gem = gems[left];
                if (map.get(gem) == 1) {
                    map.remove(gem);
                } else {
                    map.put(gem, map.get(gem) - 1);
                }
                left++;
                if (right - left < end - start) {
                    end = right;
                    start = left;
                }
            } else {
                if (right >= gems.length) break;
                String gem = gems[right];
                if (map.containsKey(gem)) {
                    map.put(gem, map.get(gem) + 1);
                } else {
                    map.put(gem, 1);
                }
                right++;
            }
        }

        return new int[]{start, end};
    }
}
