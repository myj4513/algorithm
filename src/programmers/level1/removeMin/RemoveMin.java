package programmers.level1.removeMin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveMin {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new int[]{4,3,2,1})));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1)
            return new int[]{-1};
        int min = Arrays.stream(arr).min().getAsInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        list.remove(new Integer(min));
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}