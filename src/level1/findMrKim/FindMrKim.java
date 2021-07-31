package level1.findMrKim;

public class FindMrKim {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"Jane", "Kim"}));
    }
}

class Solution{
    public String solution(String[] seoul){
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim"))
                return String.format("김서방은 %d에 있다", i);
        }
        return "";
    }
}