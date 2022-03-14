package baekjoon.p15592;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cowFeed = new int[4];
        int[] lawnmower = new int[4];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            lawnmower[i] = Integer.parseInt(st1.nextToken());
            cowFeed[i] = Integer.parseInt(st2.nextToken());
        }

        if (cowFeed[0] <= lawnmower[0] && cowFeed[2] >= lawnmower[2]) { //가로가 포함되는 경우
            if (cowFeed[1] <= lawnmower[1] && lawnmower[3] <= cowFeed[3]) { //세로가 포함되는 경우
                System.out.println(0);
            } else {
                if (lawnmower[1] <= cowFeed[1] && cowFeed[1] <= lawnmower[3] && !(lawnmower[1] <= cowFeed[3] && cowFeed[3] <= lawnmower[3]))
                    System.out.println((lawnmower[2] - lawnmower[0]) * (cowFeed[1] - lawnmower[1]));
                else if (!(lawnmower[1] <= cowFeed[1] && cowFeed[1] <= lawnmower[3]) && lawnmower[1] <= cowFeed[3] && cowFeed[3] <= lawnmower[3])
                    System.out.println((lawnmower[2] - lawnmower[0]) * (lawnmower[3] - cowFeed[3]));
                else
                    System.out.println((lawnmower[2] - lawnmower[0]) * (lawnmower[3] - lawnmower[1]));
            }
        } else {
            if (cowFeed[1] <= lawnmower[1] && lawnmower[3] <= cowFeed[3]) {
                if (lawnmower[0] <= cowFeed[0] && cowFeed[0] <= lawnmower[2] && !(lawnmower[0] <= cowFeed[2] && cowFeed[2] <= lawnmower[2]))
                    System.out.println((lawnmower[3] - lawnmower[1]) * (cowFeed[0] - lawnmower[0]));
                else if (!(lawnmower[0] <= cowFeed[0] && cowFeed[0] <= lawnmower[2]) && lawnmower[0] <= cowFeed[2] && cowFeed[2] <= lawnmower[2])
                    System.out.println((lawnmower[3] - lawnmower[1]) * (lawnmower[2] - cowFeed[2]));
                else
                    System.out.println((lawnmower[2] - lawnmower[0]) * (lawnmower[3] - lawnmower[1]));
            } else {
                System.out.println((lawnmower[2] - lawnmower[0]) * (lawnmower[3] - lawnmower[1]));
            }
        }
    }
}
