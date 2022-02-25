package programmers.level2.differentbit;

import java.util.Arrays;

public class DifferentBit {
    public static void main(String[] args) {
        Solution s = new Solution();
        long[] answer = s.solution(new long[]{2, 7});
        System.out.println("answer = " + Arrays.toString(answer));
    }
}

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1){
                answer[i] = 2;
            }
            else{
                String s = Long.toString(numbers[i], 2);
                int index0 = Long.toString(numbers[i], 2).lastIndexOf("0");
                if(index0==-1){
                    s = s.substring(1);
                    answer[i] = Long.parseLong("10"+s, 2);

                }
                else if(index0 == s.length()-1){
                    answer[i] = ++numbers[i];
                }
                else{
                    char[] chars = s.toCharArray();
                    chars[index0] = '1';
                    chars[index0+1] = '0';
                    answer[i] = Long.parseLong(String.valueOf(chars),2);
                }
            }

        }

        return answer;
    }
}
