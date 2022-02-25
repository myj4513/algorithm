package programmers.level1.primeNumberGroup;

public class PrimeNumberGroup {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1,2,7,6,4}));
    }
}

class Solution {
    int count =0;
    public int solution(int[] nums){
        boolean[] check = new boolean[nums.length];
        cntPrime(nums, check, 0, 0);
        return count;
    }

    private void cntPrime(int[] nums, boolean[] check, int n, int r){
        if(n==3){
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                if(check[i]){
                    sum += nums[i];
                }
            }
            if(isPrime(sum)) count++;
            return;
        }
        if(r==nums.length)return;
        cntPrime(nums,check, n,r+1);
        check[r] = true;
        cntPrime(nums, check, n+1,r+1);
        check[r] = false;
    }

    private boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}