package programmers.level2.lifeBoat;

import java.util.Arrays;
import java.util.Collections;

public class LifeBoat {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(new int[]{40,50,50,60,60,60, }, 100);
        System.out.println(answer);

    }
}

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int count = 0;
        int lastIdx = people.length-1;
        Integer[] p = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(p, Collections.reverseOrder());
        for(int i=0;i<p.length;i++){
            if(p[i]<limit/2.0) break;
            if(p[i]+p[lastIdx]<=limit){
                count+=2;
                lastIdx--;
            }else{
                count++;
            }
            answer++;
        }
        return (int)Math.ceil((p.length-count)/2.0) + answer;
    }
}