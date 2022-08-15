package programmers.level3.checkouterwall;

/**
 * 프로그래머스 레벨 3 - 외벽점검
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
    }
}

class Solution {
    private int[] dist;
    private List<int[]> distPerm = new ArrayList<>();

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        Arrays.sort(weak);
        int[] doubledWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            doubledWeak[i] = weak[i];
            doubledWeak[i + weak.length] = weak[i] + n;
        }
        perm(new int[dist.length], new boolean[dist.length], 0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < weak.length; i++) {
            for (int j = 0; j < distPerm.size(); j++) {
                int[] distArr = distPerm.get(j);
                int friendIdx = 0;
                for (int k = i; k < i + weak.length; k++) { //체크할 외벽
                    int base = k;
                    while (k+1 < i + weak.length && doubledWeak[k + 1] - doubledWeak[base] <= distArr[friendIdx]) {
                        k++;
                    }
                    friendIdx++;
                    if (friendIdx == dist.length && k!= i+weak.length-1) {
                        friendIdx = Integer.MAX_VALUE;
                        break;
                    }
                }
                min = Math.min(min, friendIdx);
            }
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    private void perm(int[] arr, boolean[] visited, int cnt) {
        if (cnt == arr.length) {
            int[] newArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            distPerm.add(newArr); //arr copy 고려하자
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = dist[i];
                perm(arr, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
