package level2.functionDevelopment;

import java.util.*;

public class FunctionDevelopment {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] answer = s.solution(new int[]{95,96,97,98,99}, new int[]{1,1,1,1,1});
        System.out.println(Arrays.toString(answer));
    }
}

class Solution{
    public int[] solution(int[] progresses, int[] speed){
        Queue<Progress> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            queue.add(new Progress(progresses[i], speed[i]));
        }

        while(queue.size()>0){
            int cnt = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                if(queue.peek().curP >=100){
                    queue.remove();
                    cnt++;
                }
            }
            if(cnt!=0) list.add(cnt);
            for(int i=0;i<queue.size();i++){
                Progress p = queue.remove();
                p.curP += p.speed;
                queue.add(p);
            }
        }
        return list.stream().mapToInt(i->i).toArray();

    }
}

class Progress{
    int curP;
    int speed;
    Progress(int curP, int speed){
        this.curP = curP;
        this.speed = speed;
    }
/*
    public String toString(){
        return curP+"/"+speed;
    }*/
}