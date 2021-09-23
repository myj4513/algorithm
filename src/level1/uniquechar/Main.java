package level1.uniquechar;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            String str = scanner.nextLine();
            Map<Character, Integer> map = new LinkedHashMap<>();

            for(int j=0;j<str.length();j++){
                if(map.containsKey(str.charAt(j))){
                    map.put(str.charAt(j), map.get(str.charAt(j))+1);
                }
                else{
                    map.put(str.charAt(j), 1);
                }
            }

            boolean check = true;
            for (Character character : map.keySet()) {
                if(map.get(character)==1){
                    System.out.println(str.indexOf(character));
                    check = false;
                    break;
                }
            }
            if(check){
                System.out.println(-1);
            }
        }
    }
}
