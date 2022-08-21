package programmers.level4.muzifoodtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3,1,1,1,2,4,3}, 12));
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long count = 0;
        List<Food> foodList = new ArrayList<>();
        for (int i = 0; i < food_times.length; i++) {
            foodList.add(new Food(i + 1, food_times[i]));
            count += food_times[i];
        }
        if (count < k) return -1;
        Collections.sort(foodList);
        while (k > foodList.get(0).size * foodList.size()) {
            k -= (long) foodList.get(0).size * foodList.size();
            int size = foodList.get(0).size;
            Iterator<Food> iterator = foodList.iterator();
            while (iterator.hasNext()) {
                Food food = iterator.next();
                food.size -= size;
                if (food.size <= 0) {
                    iterator.remove();
                }
            }
        }
        int idx = (int) (k % foodList.size());
        foodList.sort((o1, o2) -> o1.idx - o2.idx);
        return foodList.get(idx).idx;
    }

    class Food implements Comparable<Food> {
        int idx;
        int size;

        public Food(int idx, int size) {
            this.idx = idx;
            this.size = size;
        }

        @Override
        public int compareTo(Food o) {
            if (o.size == this.size) {
                return this.idx - o.idx;
            }
            return this.size - o.size;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "idx=" + idx +
                    ", size=" + size +
                    '}';
        }
    }
}

