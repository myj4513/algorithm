package level2.hIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HIndex {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{3, 0, 6, 1, 5});
        List<HashSet<String>> list2 = new ArrayList<>();
        HashSet<String> set2 = new HashSet<String>();
        set2.add("A");
        set2.add("B");
        list2.add(set2);
        System.out.println(list2);
        System.out.println(answer);
    }
}

class Solution {
    List<HashSet<Integer>> list;
    public int solution(int[] citations) {
        list = new ArrayList<HashSet<Integer>>();
        int answer = 0;

        for(int i=1;i<=1;i++){
            makeComb(0, 0, i,new HashSet<Integer>(), citations.length-1);
        }
        System.out.println(list);
        return answer;
    }

    public void makeComb(int index, int targetCount, int target, HashSet<Integer> set, int maxIndex){
        if(targetCount==target){
            System.out.println(set);
            list.add(set);
            return;
        }

        if(index>=maxIndex)
            return;

        set.add(index);
        makeComb(index+1, targetCount+1, target, set, maxIndex);
        set.remove(index);
        makeComb(index+1, targetCount, target, set, maxIndex);
    }
}