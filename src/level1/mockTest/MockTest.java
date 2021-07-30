package level1.mockTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    int[] p1 = {1,2,3,4,5};
    int[] p2 = {2,1,2,3,2,4,2,5};
    int[] p3 = {3,3,1,1,2,2,4,4,5,5};
    public int[] solution(int[] answers){
        List<Integer> list = new ArrayList<>();
        int[] score = new int[3];
        score[0] = countAns(answers, p1);
        score[1] = countAns(answers, p2);
        score[2] = countAns(answers, p3);
        int max = Math.max(score[0], Math.max(score[1],score[2]));
        if(score[0]==max) list.add(1);
        if(score[1]==max) list.add(2);
        if(score[2]==max) list.add(3);
        return list.stream().mapToInt(i->i).toArray();
    }

    public int countAns(int[] answer, int[] person){
        int count = 0;
        for(int i=0;i<answer.length;i++){
            if(answer[i]==person[i%person.length]) count++;
        }
        return count;
    }
}
