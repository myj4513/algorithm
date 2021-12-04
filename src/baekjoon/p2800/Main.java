package baekjoon.p2800;

import java.util.*;

public class Main {
    static Set<String> set = new TreeSet<>();
    static ArrayList<Pair> brackets = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static String s;

    public static void main(String[] args) {
        s = new Scanner(System.in).nextLine();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                brackets.add(new Pair(stack.pop(), i));
            }
        }
        remove(0, new boolean[s.length()]);

        for(String str : set){
            if(!str.equals(s)){
                System.out.println(str);
            }
        }
    }

    public static void remove(int depth, boolean[] removed) {

        if (depth == brackets.size()) {
            sb.setLength(0);

            for(int i=0;i< removed.length;i++){
                if(!removed[i]){
                    sb.append(s.charAt(i));
                }
            }
            set.add(sb.toString());
            return;
        }
        Pair bracket = brackets.get(depth);
        removed[bracket.leftIdx] = true;
        removed[bracket.rightIdx] = true;
        remove(depth+1, removed);
        removed[bracket.leftIdx] = false;
        removed[bracket.rightIdx] = false;
        remove(depth+1, removed);
    }

    private static class Pair{
        int leftIdx;
        int rightIdx;

        public Pair(int leftIdx, int rightIdx) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
        }
    }
}
