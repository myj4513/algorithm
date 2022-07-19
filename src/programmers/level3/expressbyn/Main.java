package programmers.level3.expressbyn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 프로그래머스 레벨 3 - N으로 표현
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 11));
    }
}

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        for (int i = 2; i <= 8; i++) {
            Set<Integer> set = list.get(i);
            for (int j = 1; j < i; j++) {
                Set<Integer> from = list.get(j);
                Set<Integer> to = list.get(i - j);
                for (int x : from) {
                    for (int y : to) {
                        set.add(x + y);
                        set.add(x - y);
                        set.add(x * y);
                        if(y!=0)set.add(x / y);
                    }
                }
            }
            String s = "";
            for (int k = 0; k < i; k++) {
                s += N;
            }
            set.add(Integer.parseInt(s));
        }
        for (int i = 1; i <= 8; i++) {
            if (list.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}
