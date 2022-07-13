package programmers.level3.healthtrainersconcern;

import java.util.*;

/**
 * 프로그래머스 레벨 3 - 몸짱 트레이너 라이언의 고민
 * 실패..
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, 5, new int[][]{{1140, 1200}, {1150, 1200}, {1100, 1200}, {1210, 1300}, {1220, 1280}}));
    }
}

class Solution { //n : 라커룸 사이즈 , m : timetable 수
    public int solution(int n, int m, int[][] timetable) {
        Arrays.sort(timetable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = maxPeople(m, timetable);
        if (max <= 1) return 0;
        int[] minDistance = minDistance(n);  //거리(n) 별 동시에 들어갈 수 있는 최대 사람 수

        int answer = 0;
        for (int i = 1; i < minDistance.length; i++) {
            if(max <= minDistance[i]) answer = i;
            else break;
        }
        return answer;
    }

    private int[] minDistance(int n) {
        int[] maxNum = new int[2 * n - 1];   //거리가 0부터 2*n-2 까지 들어 갈 수 있는 사람 수 Array
        maxNum[1] = n * n;
        maxNum[2] = n * n / 2 + n % 2;
        for (int i = 3; i < 2 * n - 1; i++) { //maxNum[] 모든 경우 확인
            for (int j = 0; j < n / 2; j++) { //시작점 위치(첫 열의 가장 왼쪽부터 첫 열의 중앙까지
                List<int[]> list = new ArrayList<>();
                int[] arr = new int[]{0, j};
                list.add(arr);
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) { //모든 점에 대해
                        boolean insertable = true;
                        for (int[] temp : list) {
                            if (Math.abs(temp[0] - x) + Math.abs(temp[1] - y) < i) {
                                insertable = false;
                                break;
                            }
                        }
                        if (insertable) {
                            list.add(new int[]{x, y});
                        }
                    }
                }
                maxNum[i] = Math.max(maxNum[i], list.size());
            }
        }
        return maxNum;
    }

    private int maxPeople(int m, int[][] timetable) {
        int max = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            while (!pq.isEmpty() && pq.peek() < timetable[i][0]) {
                pq.poll();
            }
            pq.add(timetable[i][1]);
            max = Math.max(max, pq.size());
        }
        return max;
    }
}