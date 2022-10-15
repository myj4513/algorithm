package programmers.level2.parcelbox;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5,4,3,2,1}));
    }
}

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int beltIdx = 1;
        boolean isAvailable = true;
        Stack<Integer> auxBelt = new Stack<>();
        for (int i = 0; i < order.length; i++) {
            while (true) {
                if (beltIdx == order[i]) {
                    beltIdx++;
                    answer++;
                    break;
                } else if (beltIdx > order[i]) {
                    if (auxBelt.peek() == order[i]) {
                        answer++;
                        auxBelt.pop();
                        break;
                    } else{
                        isAvailable = false;
                        break;
                    }
                } else if (beltIdx < order[i]) {
                    auxBelt.push(beltIdx++);
                }
            }
            if(!isAvailable)
                break;
        }
        return answer;
    }
}
