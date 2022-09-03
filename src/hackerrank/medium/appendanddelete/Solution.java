package hackerrank.medium.appendanddelete;

/**
 * HackerRank medium - Append and Delete
 */

import java.io.*;

class Result {
    public static String appendAndDelete(String s, String t, int k) {
        int diffIdx = 0;
        int deleteCnt, appendCnt;
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                diffIdx++;
            } else break;
        }
        deleteCnt = s.length() - diffIdx;
        appendCnt = t.length() - diffIdx;

        if (deleteCnt + appendCnt == k) return "Yes";
        if (deleteCnt + appendCnt < k) {
            if (diffIdx * 2 <= k - (deleteCnt + appendCnt)) {
                return "Yes";
            } else {
                if ((k - (deleteCnt + appendCnt)) % 2 == 0) {
                    return "Yes";
                } else return "No";
            }
        }
        return "No";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
