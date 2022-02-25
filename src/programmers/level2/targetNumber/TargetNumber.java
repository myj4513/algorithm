package programmers.level2.targetNumber;

public class TargetNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,1,1}, 1));
    }
}

class Solution {
    int count;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return count;
    }

    public void dfs(int[] numbers, int i, int cur, int target){
        if(i==numbers.length){
            if(cur == target)
                count++;
            return;
        }

        dfs(numbers, i+1, cur+numbers[i], target);
        dfs(numbers, i+1, cur-numbers[i], target);

    }
}