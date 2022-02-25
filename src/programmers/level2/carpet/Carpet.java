package programmers.level2.carpet;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(24,24);
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int width=0;
        int height=0;
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i==0){
                height = i;
                width = yellow/i;
                if(brown== 4+(height*2+width*2))
                    break;
            }
        }

        return new int[]{width+2, height+2};
    }
}