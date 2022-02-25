package programmers.level1.dayOf2016;

import java.util.Calendar;

public class DayOf2016 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5,24));
    }
}

class Solution {
    String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    public String solution(int a, int b){
        Calendar cal = Calendar.getInstance();
        cal.set(2016,a-1,b);

        return dayOfWeek[cal.get(Calendar.DAY_OF_WEEK)-1];
    }
}