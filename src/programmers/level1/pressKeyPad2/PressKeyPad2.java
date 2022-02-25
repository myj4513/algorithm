package programmers.level1.pressKeyPad2;

public class PressKeyPad2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution(new int[]{1,2,3,4,5,6,7,8,9,0}, "right");
        System.out.println(answer);
    }
}

class Solution {
    int[][] pos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}, //9
    };

    int[] lPos = new int[]{3,0};
    int[] rPos = new int[]{3,2};
    String hand;
    public String solution(int[] numbers, String hand){
        String answer = "";
        this.hand = hand.equals("right")?"R":"L";
        for(int num : numbers){
            String thumb = getThumb(num);
            answer+= thumb;
            if(thumb.equals("R")) rPos = pos[num];
            if(thumb.equals("L")) lPos = pos[num];
        }
        return answer;
    }

    private String getThumb(int num){
        if(num==1||num==4||num==7) return "L";
        if(num==3||num==6||num==9) return "R";

        int lDis = getDistance(lPos, pos[num]);
        int rDis = getDistance(rPos, pos[num]);
        if(lDis>rDis) return "R";
        if(rDis>lDis) return "L";

        return this.hand;
    }

    private int getDistance(int[] fromPos, int[] toPos){
        return Math.abs(fromPos[0]-toPos[0]) + Math.abs(fromPos[1]-toPos[1]);
    }
}
