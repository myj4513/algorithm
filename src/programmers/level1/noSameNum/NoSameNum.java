package programmers.level1.noSameNum;

import java.util.ArrayList;
import java.util.List;

public class NoSameNum {
    public static void main(String[] args) {
        Solution s = new Solution();

    }
}

class Solution{
    public int[] solution(int[] arr){
        List<Integer> list = new ArrayList<>();
        int prev = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=prev){
                list.add(arr[i]);
                prev = arr[i];
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}