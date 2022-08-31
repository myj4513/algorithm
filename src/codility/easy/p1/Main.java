package codility.easy.p1;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 4, 2, 5}));
    }
}

class Solution {
    public int solution(int[] A) {
        int answer = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            maxNum = Math.max(maxNum, A[i]);
            if (maxNum == i + 1) {
                answer++;
            }

        }
        return answer;
    }
}


