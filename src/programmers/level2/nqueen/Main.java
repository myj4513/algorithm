package programmers.level2.nqueen;

/**
 * 프로그래머스 레벨 2 - n Queens
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }
}

class Solution {
    private int answer = 0;
    public int solution(int n) {
        bfs(0, new int[n], n);
        return answer;
    }

    private void bfs(int depth, int[] arr, int n) {
        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean isAvailable = true;
            for (int j = 0; j < depth; j++) {
                int dx = Math.abs(depth - j);
                int dy = Math.abs(i - arr[j]);
                if(dx == dy || arr[j] == i){
                    isAvailable = false;
                    break;
                }
            }

            if (isAvailable) {
                arr[depth] = i;
                bfs(depth+1, arr, n);
            }
        }
    }
}
