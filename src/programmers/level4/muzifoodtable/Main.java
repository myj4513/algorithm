package programmers.level4.muzifoodtable;

/**
 * 프로그래머스 레벨 4 - 무지의 먹방 라이브 (효율성 테스트 통과)
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3, 1, 2}, 5));
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        List<Food> foodList = new ArrayList<>();
        long count = 0;
        for (int i = 0; i < food_times.length; i++) {
            foodList.add(new Food(i + 1, food_times[i]));
            count += food_times[i];
        }
        if (count <= k) return -1;
        foodList.sort(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.time - o2.time;
            }
        });
        int idx = 0;
        int removedTime = 0;
        while (k > ((long) foodList.get(idx).time - removedTime) * (foodList.size() - idx)) {
            k -= ((long) foodList.get(idx).time - removedTime) * (foodList.size() - idx);
            removedTime = foodList.get(idx).time;
            while (removedTime >= foodList.get(idx).time) {
                idx++;
            }
        }
        List<Food> foods = foodList.subList(idx, foodList.size());
        foods.sort((o1, o2) -> o1.idx - o2.idx);
        k %= foods.size();
        return foods.get((int) k).idx;
    }

    class Food {
        int idx;
        int time;

        public Food(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}