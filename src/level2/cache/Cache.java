package level2.cache;

import java.util.*;

public class Cache {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(0, new String[]{"jeju", "otawa", "jeju", "JEJU"});
        System.out.println("answer = " + answer);
    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize==0){
            return 5 * cities.length;
        }

        Queue<String> queue = new LinkedList<>();

        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase(Locale.ROOT);
            if(queue.contains(city)){
                answer++;
                queue.remove(city);

            }
            else{
                if(queue.size()>=cacheSize){
                    queue.poll();
                }
                answer +=5;
            }
            queue.add(city);
        }
        return answer;
    }
}