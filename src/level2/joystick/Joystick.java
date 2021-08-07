package level2.joystick;

public class Joystick {
    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution("ABABAAAAAAABA");
        System.out.println(answer);
    }
}

class Solution {
    int pos = 0;
    public int solution(String name) {
        int answer = 0;
        int count=0;
        boolean[] set = new boolean[name.length()];
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)=='A')
                set[i]=true;
            else
                count++;
        }

        while(count!=0){
            answer += findNextPos(set);
            if(name.charAt(pos)!='A'){
                answer +=countMove(name.charAt(pos));
                count--;
                set[pos] = true;
            }
        }
        return answer;
    }

    public int findNextPos(boolean[] set){
        for(int i=0;i<set.length;i++){
            if(!set[(pos+i)%set.length]){
                pos = (pos+i)%set.length;
                return i;
            }
            if(!set[(pos-i+set.length)%set.length]) {
                pos = (pos - i + set.length) % set.length;
                return i;
            }
        }
        return 0;
    }

    public int countMove(char c){
        if(c<='N')
            return c-'A';
        else
            return 'Z'+1-c;
    }
}
