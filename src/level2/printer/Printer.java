package level2.printer;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{2,1,3,2}, 2));
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i< priorities.length;i++){
            map.put(i, priorities[i]);
            queue.add(i);
        }
        while(!queue.isEmpty()){
            int doc = queue.poll();
            boolean hasHigher = false;
            for(int priority : map.values()){
                if(map.get(doc)<priority){
                    hasHigher = true;
                    break;
                }
            }
            if(hasHigher)
                queue.add(doc);
            else{
                answer++;
                if(doc==location){
                    return answer;
                }
                map.remove(doc);
            }

        }
        return -1;
    }
}