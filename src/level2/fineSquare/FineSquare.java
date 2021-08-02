package level2.fineSquare;

public class FineSquare {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(100000000, 100000000));
    }
}

class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h;
        for(long i=0;i<h;i++){
            long start = ((long)w*i)/(long)h;
            long end = ((long)w*(i+1)+(h-1))/(long)h;
            answer -= end-start;
        }
        return answer;
    }
}