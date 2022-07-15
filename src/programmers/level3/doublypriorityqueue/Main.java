package programmers.level3.doublypriorityqueue;

/**
 * 프로그래머스 레벨 3 - 이중우선순위큐
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"I -45", "I -653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            if (split[0].equals("I")) {
                int tmp = Integer.parseInt(split[1]);
                if (list.isEmpty()) {
                    list.add(tmp);
                    continue;
                }
                int start = 0;
                int end = list.size() - 1;
                int mid = -1;
                while (start <= end) {
                    mid = (start + end) / 2;
                    if (list.get(mid) < tmp) {
                        mid++;
                        start = mid;
                    } else if (list.get(mid) > tmp) {
                        end = mid - 1;
                    } else {
                        break;
                    }
                }
                list.add(mid, tmp);
            } else {
                if(list.isEmpty()) continue;
                if (split[1].equals("1")) {
                    list.remove(list.size() - 1);
                } else {
                    list.remove(0);
                }
            }
        }
        if(list.isEmpty()) return new int[]{0, 0};
        return new int[]{list.get(list.size() - 1), list.get(0)};
    }
}