package level2.smallestinteger;

import java.util.*;

public class SmallestInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] arr = scanner.nextLine().split(" ");
        int[] intArr = new int[n];
        for(int i=0;i<n;i++){
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(intArr);
        System.out.println(intArr[n-1]);
    }
}
