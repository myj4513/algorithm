package programmers.level1.addPosNeg;

public class AddPosNeg {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{4,7,12}, new boolean[]{true, false, true}));
    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < signs.length; i++){
            if(signs[i]){
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}