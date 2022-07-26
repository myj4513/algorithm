package programmers.level3.multileveltoothbrushsales;

import java.util.*;

/**
 * 프로그래머스 레벨 3 - 다단계 칫솔 판매
 */

public class Main {
    public static void main(String[] args) {
        int[] result = new Solution().solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        );
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    private Map<String, String> parentMap;
    private Map<String, Integer> profits;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        parentMap = new HashMap<>();
        profits = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            profits.put(enroll[i], 0);
        }
        for (int i = 0; i < seller.length; i++) {
            recur(seller[i], amount[i] * 100);
        }
        int answer[] = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profits.get(enroll[i]);
        }
        return answer;
    }

    private void recur(String salesman, int profit) {
        if(profit == 0) return;
        if (parentMap.containsKey(salesman)) {
            String parent = parentMap.get(salesman);
            int toParent = profit/10;
            recur(parent, toParent);
            profits.put(salesman, profits.get(salesman) + profit - toParent);
        }
    }
}