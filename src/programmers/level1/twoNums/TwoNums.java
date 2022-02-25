package programmers.level1.twoNums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNums {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new int[]{10,3,3,2,2,1,});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution{
    public int[] solution(int[] numbers){

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        Object[] temp = set.toArray();
        for(int i=0;i<set.size();i++){
            answer[i] = (int)temp[i];
        }
        return set.stream().sorted().mapToInt(i->i.intValue()).toArray();
    }
}