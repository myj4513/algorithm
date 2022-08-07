package hackerrank.medium.magicsquareforming;

/**
 * HackerRank Medium - forming a magic number
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][][] magicSquare = new int[][][]{
                {
                        {8, 1, 6},
                        {3, 5, 7},
                        {4, 9, 2}
                },
                {
                        {4, 3, 8},
                        {9, 5, 1},
                        {2, 7, 6}
                },
                {
                        {2, 9, 4},
                        {7, 5, 3},
                        {6, 1, 8}
                },
                {
                        {6, 7, 2},
                        {1, 5, 9},
                        {8, 3, 4}
                },
                {
                        {6, 1, 8},
                        {7, 5, 3},
                        {2, 9, 4}
                },
                {
                        {8, 3, 4},
                        {1, 5, 9},
                        {6, 7, 2}
                },
                {
                        {4, 9, 2},
                        {3, 5, 7},
                        {8, 1, 6}
                },
                {
                        {2, 7, 6},
                        {9, 5, 1},
                        {4, 3, 8}
                }
        };
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < magicSquare.length; i++) {
            int diff = 0;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    diff += Math.abs(s.get(y).get(x) - magicSquare[i][x][y]);
                }
            }
            min = Math.min(min, diff);
        }
        return min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
