package programmers.level3.doublypriorityqueue;

/**
 * 프로그래머스 레벨 3 - 이중우선순위큐
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}

class Solution {
    public int[] solution(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < operations.length; i++) {
            char command = operations[i].charAt(0);
            int num = Integer.parseInt(operations[i].substring(2));
            if (command == 'I') {
                addList(list, num);
            } else if (command == 'D') {
                if(list.isEmpty()) continue;
                if (num == 1) {
                    list.removeLast();
                } else {
                    list.removeFirst();
                }
            }
        }

        if (list.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{list.getLast(), list.getFirst()};
        }
    }

    private void addList(List<Integer> list, int num) {
        //binary
        int start = 0;
        int end = list.size() - 1;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= num) {
                result = mid;
                end = mid - 1;
            } else {
                result = mid + 1;
                start = mid + 1;
            }
        }
        list.add(result, num);
    }
}