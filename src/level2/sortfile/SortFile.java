package level2.sortfile;

import java.util.Arrays;
import java.util.Comparator;

public class SortFile {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] answer = s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        System.out.println("answer = " + Arrays.toString(answer));
    }
}

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                int result = head1.compareToIgnoreCase(head2);
                if(result==0){
                    return convert(o1, head1.length()) - convert(o2, head2.length());
                }
                return result;
            }
        });
        return files;
    }

    public int convert(String str, int l){
        str = str.substring(l);
        String result = "";
        for(char c : str.toCharArray()){
            if(Character.isDigit(c) && result.length()<=5)
                result+=c;
            else break;
        }
        return Integer.parseInt(result);
    }
}
