package level1.minmax;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.nextLine().split(" ");
        int min = toMin(s[0]) + toMin(s[1]);
        int max = toMax(s[0]) + toMax(s[1]);

        System.out.println(min + " "+max);


    }

    public static int toMin(String s){
        String result=s;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='6'){
                result = result.substring(0,i)+5+result.substring(i+1);
            }
        }
        return Integer.parseInt(result);
    }

    public static int toMax(String s){
        String result=s;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='5'){
                result = result.substring(0,i)+6+result.substring(i+1);
            }
        }
        return Integer.parseInt(result);

    }
}
