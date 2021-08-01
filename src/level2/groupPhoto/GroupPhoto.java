package level2.groupPhoto;

import java.util.ArrayList;

public class GroupPhoto {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(2, new String[]{"N~F=0", "R~T>2"}));
    }
}

class Solution{
    private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};

    public int solution(int n, String[] data){
        String[] output = new String[8];
        int answer = 0;
        for(int a=0;a<8;a++){
            output[0] = friends[a];
            for(int b=0;b<8;b++)
                if(a!=b){
                    output[1] = friends[b];
                    for(int c=0;c<8;c++)
                        if(c!=a && c!=b){
                            output[2] = friends[c];
                            for(int d=0;d<8;d++)
                                if(d!=a && d!=b && d!=c){
                                    output[3] = friends[d];
                                    for(int e=0;e<8;e++)
                                        if(e!=a && e!=b && e!=c && e!=d){
                                            output[4] = friends[e];
                                            for(int f=0;f<8;f++)
                                                if(f!=a && f!=b && f!=c && f!=d && f!=e){
                                                    output[5] = friends[f];
                                                    for(int g=0;g<8;g++)
                                                        if(g!=a && g!=b && g!=c && g!=d && g!=e && g!=f){
                                                            output[6] = friends[g];
                                                            for(int h=0;h<8;h++)
                                                                if(h!=a && h!=b && h!=c && h!=d && h!=e && h!=f && h!=g){
                                                                    output[7] = friends[h];
                                                                    if(check(n, data, output))
                                                                        answer++;
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }

        return answer;
    }

    public boolean check(int n, String[] data, String[] output){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<output.length;i++){
            list.add(output[i]);
        }

        for(int i=0;i<n;i++){
            String s1 = Character.toString(data[i].charAt(0));
            String s2 = Character.toString(data[i].charAt(2));
            String operator = Character.toString(data[i].charAt(3));
            int param = data[i].charAt(4)-'0';
            if(operator.equals("=")){
                if(Math.abs(list.indexOf(s1)-list.indexOf(s2))-1!=param)
                    return false;
            }
            else if(operator.equals(">")){
                if(Math.abs(list.indexOf(s1)-list.indexOf(s2))-1<=param)
                    return false;
            }
            else if(operator.equals("<")){
                if(Math.abs(list.indexOf(s1)-list.indexOf(s2))-1>=param)
                    return false;
            }
        }

        return true;
    }
}
