package level2.differentbit;

import java.util.Arrays;

public class DifferentBit {
    public static void main(String[] args) {
        Solution s = new Solution();
        long[] answer = s.solution(new long[]{2, 31});
        System.out.println("answer = " + Arrays.toString(answer));
    }
}

/*class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0;i<numbers.length;i++){
            long num = numbers[i];
            while(true){
                num++;
                String binary = Long.toString(numbers[i]^num, 2);
                int count = 0;
                for(int j=0;j<binary.length();j++){
                    if(binary.charAt(j)=='1')
                        count++;
                    if(count>2)
                        break;
                }
                if(count<=2)
                    break;
            }
            answer[i] = num;
        }

        return answer;
    }
}*/

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1){
                answer[i] = 2;
            }
            else{
                int index0 = Long.toString(numbers[i], 2).lastIndexOf("0");
                if(index0==-1){
                    String s = Long.toString(numbers[i], 2).substring(1);
                    answer[i] = Long.parseLong("10"+s, 2);

                }
                else{
                    char[] chars = Long.toString(numbers[i], 2).toCharArray();
                    chars[index0] = '1';
                    answer[i] = Long.parseLong(chars.toString(),2);
                }
            }

        }

        return answer;
    }
}
