package programmers.level2.judgecodingtestG;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] student = new int[n];
        String[] s = scanner.nextLine().split(" ");
        for(int i=0;i<n;i++){
            student[i] = Integer.parseInt(s[i]);
        }
        int m = Integer.parseInt(scanner.nextLine()); //알고싶은 학생수
        s = scanner.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(Integer.parseInt(s[i]));
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.get(student[i])==null) {
                List l = new ArrayList<>();
                l.add(i+1);
                map.put(student[i], l);
            }
            else{
                List l = map.get(student[i]);
                l.add(i+1);
                map.put(student[i], l);
            }

        }

        for (int st : list) {
            if(map.get(st)==null) System.out.println(-1);
            else {
                List<Integer> integers = map.get(st);
                int size = integers.size();
                for(int i=0;i<size;i++){
                    System.out.print(integers.get(i)+" ");
                }
                System.out.println();
            }
        }

    }
}
