package programmers.level3.connectisland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프로그래머스 레벨 3 - 섬 연결하기
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        Map<Integer, List<Bridge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int price = costs[i][2];
            graph.get(from).add(new Bridge(to, price));
            graph.get(to).add(new Bridge(from, price));
        }


        boolean[] visited = new boolean[n];
        visited[0] = true;
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minTo = -1;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    List<Bridge> bridges = graph.get(j);
                    for (Bridge bridge : bridges) {
                        if (!visited[bridge.getTo()] && bridge.getPrice() < min) {
                            min = bridge.getPrice();
                            minTo = bridge.getTo();
                        }
                    }
                }
            }
            visited[minTo] = true;
            answer += min;
        }
        return answer;
    }

    class Bridge {
        int to;
        int price;

        public Bridge(int to, int price) {
            this.to = to;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public int getTo() {
            return to;
        }
    }
}
