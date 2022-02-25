package programmers.level2.camouflage;

import java.util.*;

public class Camouflage {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}});
        System.out.println(answer);
    }
}


class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i< clothes.length;i++){
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.get(clothes[i][1])+1);
            else
                map.put(clothes[i][1], 1);
        }
        int count = 1;
        for(String s : map.keySet()){
            count *= map.get(s)+1;
        }
        answer = count-1;
        return answer;
    }
}