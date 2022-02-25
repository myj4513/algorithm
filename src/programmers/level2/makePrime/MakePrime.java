package programmers.level2.makePrime;

import java.util.HashSet;
import java.util.Set;

public class MakePrime {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("999999999"));
        System.out.println(s.isPrime(9));
    }
}

class Solution {
    String num;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        num = numbers;
        int answer = 0;

        for(int i=1;i<=numbers.length();i++){
            permutation(0, i, new boolean[numbers.length()], "");
        }
        System.out.println(set);
        for(int num : set){
            if(isPrime(num))
                answer++;
        }
        return answer;
    }

    public void permutation(int count, int max, boolean[] check, String s){
        if(count==max){
            set.add(Integer.parseInt(s));
            return;
        }
        for(int i=0;i<num.length();i++){
            if(check[i]==false){
                char c = num.charAt(i);
                check[i]=true;
                permutation(count+1, max, check, s+c);
                check[i]=false;
            }
        }
    }

    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}