package level1.rootDetermination;

public class RootDetermination {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(121));
    }
}

class Solution {
    public long solution(long n) {
        if(Math.sqrt(n)==(int)Math.sqrt(n))
            return (long)((Math.sqrt(n)+1)*(Math.sqrt(n)+1));
        else return -1;
    }
}