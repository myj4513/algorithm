package programmers.level2.candidiateKey;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
        System.out.println(answer);
    }
}


class Solution {
    List<HashSet<Integer>> list = new ArrayList<>();
    String[][] relations;
    public int solution(String[][] relation) {
        int answer = 0;
        relations = relation;
        for(int i=1;i<=relation[0].length;i++){
            makeSet(0, 0, i, new HashSet<Integer>(), relation[0].length-1);
        }
        return list.size();
    }

    public void makeSet(int index, int targetCount, int target, HashSet<Integer> set, int maxIndex){
        if(targetCount == target){
            if(isUnique(set)){
                boolean minimality = true;
                for(HashSet<Integer> tmp : list){
                    if(set.containsAll(tmp))
                        minimality = false;
                }
                if(minimality){
                    HashSet<Integer> newSet = new HashSet<>(set);
                    list.add(newSet);
                }
            }
            return;
        }
        if(index>maxIndex)
            return;

        set.add(index);
        makeSet(index+1, targetCount+1, target,set,maxIndex);
        set.remove(index);
        makeSet(index+1, targetCount, target, set, maxIndex);
    }

    public boolean isUnique(HashSet<Integer> set){
        Set<String> uniqueSet = new HashSet<String>();
        for(int i=0;i<relations.length;i++){
            String s = "";
            for(int j : set){
                s += relations[i][j]+"/";
            }
            uniqueSet.add(s);
        }
        return uniqueSet.size()==relations.length;
    }
}