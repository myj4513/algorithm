package secretMap;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(5,new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
    }
}

class Solution{
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] strArr1 = new String[n];
        for (int i = 0; i < n; i++){
            strArr1[i] = Integer.toString(arr1[i], 2);
            while(strArr1[i].length()<n)
                strArr1[i] = "0"+strArr1[i];
        }
        String[] strArr2 = new String[n];
        for (int i = 0; i < n; i++){
            strArr2[i] = Integer.toString(arr2[i], 2);
            while(strArr2[i].length()<n)
                strArr2[i] = "0"+strArr2[i];
        }
        String[] strArr3 = new String[n];
        for(int i=0;i<n;i++){
            String s = "";
            for(int j=0;j<strArr1[i].length();j++){
                if(strArr1[i].charAt(j)=='1' || strArr2[i].charAt(j)=='1')
                    s+="#";
                else
                    s+=" ";
            }
            strArr3[i] = s;
        }

        return strArr3;

    }
}
