package programmers.level3.thanksgivingtraffic;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
        }));
    }
}

class Solution {
    public int solution(String[] lines) {
        int[] startTime = new int[lines.length];
        int[] finishTime = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] lineArr = lines[i].split(" ");
            finishTime[i] = timeToInt(lineArr[1].split(":|\\."));
            String[] lenArr = lineArr[2].replace("s", "").split("\\.");
            int len;
            if (lenArr.length == 1) {
                len = Integer.parseInt(lenArr[0]) * 1000;
            } else
                len = Integer.parseInt(lenArr[0]) * 1000 + Integer.parseInt(lenArr[1]);
            startTime[i] = finishTime[i] - len + 1;
        }

        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            int startLimit = finishTime[i];
            int finishLimit = startLimit + 999;
            int count = 0;
            for (int j = 0; j < lines.length; j++) {
                if (startTime[j] <= startLimit && finishLimit <= finishTime[j])
                    count++;
                else if (startLimit <= startTime[j] && startTime[j] <= finishLimit) {
                    count++;
                } else if (startLimit <= finishTime[j] && finishTime[j] <= finishLimit) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    int timeToInt(String[] arr) {
        int t = 0;
        t += Integer.parseInt(arr[0]) * 1000 * 60 * 60;
        t += Integer.parseInt(arr[1]) * 1000 * 60;
        t += Integer.parseInt(arr[2]) * 1000;
        t += Integer.parseInt(arr[3]);
        return t;
    }
}
