package baekjoon.p20436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static char[][] keyboard;
    static Set<Character> leftSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        keyboard = new char[][]{
                {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
                {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
                {'z', 'x', 'c', 'v', 'b', 'n', 'm'}
        };

        Character[] left = new Character[]{'q','w','e','r','t','a','s','d','f','g','z','x','c','v'};
        leftSet = Arrays.stream(left).collect(Collectors.toSet());

        char lPos = st.nextToken().charAt(0);
        char rPos = st.nextToken().charAt(0);

        String input = br.readLine();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (isLeft(target)) {
                int lDis = getDistance(target, lPos);
                result += lDis;
                lPos = target;
            } else {
                int rDis = getDistance(target, rPos);
                result += rDis;
                rPos = target;
            }
            result++;
        }
        System.out.println(result);
    }

    public static int getDistance(char target, char curPos) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;

        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[i].length; j++) {
                if (target == keyboard[i][j]) {
                    x1 = i;
                    y1 = j;
                }
                if (curPos == keyboard[i][j]) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static boolean isLeft(char ch) {
        if (leftSet.contains(ch)) {
            return true;
        }
        return false;
    }

}
