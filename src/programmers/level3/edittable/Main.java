package programmers.level3.edittable;

/**
 * 프로그래머스 레벨 3 - 표 편집
 */

import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        System.out.println(new Solution().solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(new Solution().solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int tableSize = n;
        for (int i = 0; i < cmd.length; i++) {
            char ch = cmd[i].charAt(0);
            if (ch == 'U') {
                k -= Integer.parseInt(cmd[i].substring(2));
            } else if (ch == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            } else if (ch == 'C') {
                stack.push(k);
                tableSize--;
                if (k == tableSize) k--;
            } else {
                if (stack.pop() <= k) {
                    k++;
                }
                tableSize++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tableSize; i++) {
            sb.append('O');
        }
        while (!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), 'X');
        }
        return sb.toString();
    }
}
