package programmers.level2.parkingfee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(
                new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"})));
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> totalParkingTimeMap = new HashMap<>();
        for (String record : records) {
            String[] s = record.split(" ");
            if (!map.isEmpty() && map.containsKey(s[1])) {
                int parkingTime = getParkingTime(map.remove(s[1]), s[0]);
                if (totalParkingTimeMap.containsKey(s[1]))
                    totalParkingTimeMap.put(s[1], totalParkingTimeMap.get(s[1]) + parkingTime);
                else
                    totalParkingTimeMap.put(s[1], parkingTime);
            } else
                map.put(s[1], s[0]);
        }
        for (String key : map.keySet()) {
            String in = map.get(key);
            int parkingTime = getParkingTime(in, "23:59");
            if (totalParkingTimeMap.containsKey(key))
                totalParkingTimeMap.put(key, totalParkingTimeMap.get(key) + parkingTime);
            else
                totalParkingTimeMap.put(key, parkingTime);
        }

        for (String s : totalParkingTimeMap.keySet()) {
            totalParkingTimeMap.put(s, getFee(totalParkingTimeMap.get(s), fees));
        }

        return totalParkingTimeMap.keySet().stream().sorted().mapToInt(s -> totalParkingTimeMap.get(s)).toArray();
    }

    int getFee(int parkingTime, int[] fees) {
        if(parkingTime <=fees[0])
            return fees[1];
        return fees[1] + (int) Math.ceil((double) (parkingTime - fees[0]) / fees[2]) * fees[3];
    }

    int getParkingTime(String in, String out) {
        String[] inArr = in.split(":");
        String[] outArr = out.split(":");
        return (Integer.parseInt(outArr[0]) - Integer.parseInt(inArr[0])) * 60 + Integer.parseInt(outArr[1]) - Integer.parseInt(inArr[1]);
    }
}
