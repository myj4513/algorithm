package programmers.level3.baduser;

/**
 * 프로그래머스 레벨 3 - 불량 사용자
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
                new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}

class Solution {
    List<List<Integer>> list;
    HashSet<HashSet<Integer>> answerSet;
    public int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replaceAll("\\*", ".");
        }
        list = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int j = 0; j < banned_id.length; j++) {

            for (int i = 0; i < user_id.length; i++) {
                if (Pattern.matches(banned_id[j], user_id[i])) {
                    list.get(j).add(i);
                }
            }
        }
        answerSet = new HashSet<>();
        comb(banned_id.length,0, new HashSet<>());

        return answerSet.size();
    }

    private void comb(int n, int depth, HashSet<Integer> set) {
        if (depth == n) {
            answerSet.add(set);
            return;
        }
        List<Integer> matchList = this.list.get(depth);
        for (int i = 0; i < matchList.size(); i++) {
            int num = matchList.get(i);
            if (!set.contains(num)) {
                HashSet<Integer> newSet = new HashSet<>(set);
                newSet.add(num);
                comb(n, depth+1, newSet);
            }
        }
    }
}
