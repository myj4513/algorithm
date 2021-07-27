package lottery;

import java.util.Arrays;

public class Lottery {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{44,1,0,0,31,25}, new int[]{31,10,45,1,6,19})));
    }
}

class Solution{
    public int[] solution(int[] lottos, int[] win_nums){
        int score = 0;
        int erasedNum = 0;
        for(int num : lottos)
            if(num == 0 ) erasedNum++;
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j]) score++;
            }
        }
        return new int[]{getRank(score+erasedNum),getRank(score)};
    }

    public int getRank(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
        }
        return 6;
    }
}