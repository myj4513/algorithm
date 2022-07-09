package programmers.skillchecktest.level2.problem1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{70, 50, 80, 50}, 100));
    }
}

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int begin = 0;
        int end = people.length - 1;
        int count = 0;
        while (begin <= end) {
            if (begin == end) {
                count++;
                break;
            }
            if (people[begin] + people[end] <= limit) {
                begin++;
            }
            end--;
            count++;
        }
        return count;
    }
}
