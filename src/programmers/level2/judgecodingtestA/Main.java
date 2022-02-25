package programmers.level2.judgecodingtestA;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            String s = scanner.nextLine();
            for(int j=0;j<s.length();j++){
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), map.get(s.charAt(j))+1);
                }
                else{
                    map.put(s.charAt(j), 1);
                }
            }
        }

        boolean result = true;
        for (Character character : map.keySet()) {
            if(map.get(character) % n != 0){
                result = false;
            }
        }

        System.out.println(result);
    }
}
