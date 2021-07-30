package level1.pressKeyPad;

public class PressKeyPad{
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution(new int[]{3,2,1,4,5,9,5}, "right");
        System.out.println(answer);
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lPos = 10;
        int rPos = 12;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1 || numbers[i] == 4 || numbers[i] ==7){
                lPos = numbers[i];
                answer+="L";
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                rPos = numbers[i];
                answer+="R";
            } else{
                int ldis = getDistance(lPos, numbers[i]);
                int rdis = getDistance(rPos, numbers[i]);

                if(ldis==rdis){
                    if(hand.equals("right")){
                        rPos = numbers[i];
                        answer += "R";
                    }
                    else{
                        lPos = numbers[i];
                        answer += "L";
                    }
                }
                else if(ldis>rdis){
                    rPos=numbers[i];
                    answer += "R";
                }
                else{
                    lPos=numbers[i];
                    answer += "L";
                }
            }
        }
        return answer;
    }

    public int getDistance(int from, int to){
        int count = 0;
        if(from == 0) from = 11;
        if(to == 0) to = 11;
        while(from != to){
            if(to > from){
                if((to-from)>=3){
                    count++;
                    from+=3;
                }
                else{
                    count++;
                    from++;
                }
            }
            else{
                if((from-to)>=3){
                    count++;
                    from-=3;
                }
                else{
                    count++;
                    from--;
                }
            }
        }
        return count;
    }
}