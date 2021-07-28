package Budget;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{5,4,3,2,1}, 10));
    }
}

class Solution{
    public int solution(int[] d, int budget){
        int answer = 0;
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            budget-=d[i];
            if(budget<0)
                break;
            answer++;
        }
        return answer;
    }
}
