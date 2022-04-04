package baekjoon.p4673;

public class Main {
    public static void main(String[] args) {
        boolean[] isNotSelf = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            int n = i;
            int sum = n;
            while (n > 0) {
                sum += n%10;
                n/=10;
            }
            if(sum <10001)isNotSelf[sum] = true;
        }
        for (int i = 1; i < 10001; i++) {
            if (!isNotSelf[i]) {
                System.out.println(i);
            }
        }
    }
}