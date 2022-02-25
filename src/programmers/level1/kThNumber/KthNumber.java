package programmers.level1.kThNumber;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(	new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution{
    public int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];
        for(int x=0;x<commands.length;x++){
            int i = commands[x][0]-1;
            int j = commands[x][1];
            int k = commands[x][2]-1;
            int[] tmp = Arrays.copyOfRange(array, i,j);
            Arrays.sort(tmp);
            answer[x] = tmp[k];
        }
        return answer;
    }
}
