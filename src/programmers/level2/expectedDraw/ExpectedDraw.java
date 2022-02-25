package programmers.level2.expectedDraw;

import java.util.LinkedList;
import java.util.Queue;

public class ExpectedDraw {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8,1,8));
    }
}

class Solution
{
    public int solution(int n, int a, int b)
    {
        int c = a%2==0?a:a+1;
        int d = b%2==0?b:b+1;
        a = Math.min(c,d);
        b = Math.max(c,d);
        System.out.println(a+""+b);
        if(a==b) return 1;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n/2;i++){
            queue.add(i*2);
        }
        int answer = 1;
        while(true){
            answer++;
            int size = queue.size()/2;
            for(int i=0;i<size;i++){
                int x = queue.poll();
                int y = queue.poll();
                if(a==x && b==y) return answer;
                if(x==a || x==b)
                    queue.add(x);
                else
                    queue.add(y);
            }
        }
    }
}