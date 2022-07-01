package programmers.level1.failureRate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FailureRate {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            stageList.add(new Stage(i));
        }

        for (int i = 0; i < stages.length; i++) {
            Stage stage = stageList.get(stages[i] - 1);
            stage.pCnt++;
        }
        double cnt = stageList.get(N).pCnt;
        for (int i = N - 1; i >= 0; i--) {
            Stage stage = stageList.get(i);
            cnt += stage.pCnt;
            if (cnt == 0) {
                stage.failureRate = 0;
            } else {
                stage.failureRate = stage.pCnt / cnt;
            }

        }
        Collections.sort(stageList);
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).num;
        }

        return answer;
    }
}

class Stage implements Comparable<Stage> {
    int num;
    int pCnt;
    double failureRate;

    public Stage(int num) {
        this.num = num;
        this.pCnt = 0;
        this.failureRate = 0.0;
    }

    @Override
    public int compareTo(Stage o) {
        if (Double.compare(o.failureRate, this.failureRate) == 0) {
            return this.num - o.num;
        }
        return Double.compare(o.failureRate, this.failureRate);
    }
}