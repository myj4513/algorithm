package RecommendID;

public class RecommendID {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution("..");
        System.out.println(answer);
    }
}

class Solution {
    public String solution(String new_id){
        new_id = new_id.toLowerCase(); //소문자 변경
        new_id = new_id.replaceAll("[^-_.0-9a-z]","");  //특수문자 제한
        new_id = new_id.replaceAll("^[.]{2,}$","");   //연속되는 . 제거
        if(new_id.length()>0 && new_id.charAt(0)=='.'){  //시작 문자 . 제거
            new_id = new_id.substring(1);
        }
        if(new_id.length()>0 && new_id.charAt(new_id.length()-1)=='.'){   //종료 문자 . 제거
            new_id = new_id.substring(0,new_id.length()-1);
        }
        //new_id = new_id.replaceAll("^[.]|[.]$","");
        if(new_id.equals("")) new_id = "a";
        if(new_id.length()>15) new_id = new_id.substring(0,15); //15자 초과 시 제거
        if(new_id.charAt(new_id.length()-1)=='.'){  //15자 제한 후 마지막이 .일 경우 제거
            new_id = new_id.substring(0,new_id.length()-1);
        }
        while(new_id.length()<=2){  //2자 이하일 경우 확장
            char c = new_id.charAt(new_id.length()-1);
            new_id+=c;
        }
        return new_id;
    }
}