package level2.largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution(new int[]{151,15});
        System.out.println(result);
    }
}

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        for(int i=0;i<nums.length;i++){
            answer += nums[i];
        }
        if(nums[0].equals("0"))
            answer = "0";
        return answer;
    }
}