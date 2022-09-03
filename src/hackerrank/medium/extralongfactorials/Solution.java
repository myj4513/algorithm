package hackerrank.medium.extralongfactorials;

/**
 * HackerRank medium - extra long factorials
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Result {

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger bi = new BigInteger("1");
        for (int i = n; i > 1; i--) {
            bi = bi.multiply(new BigInteger(i + ""));
        }
        System.out.println(bi);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}
