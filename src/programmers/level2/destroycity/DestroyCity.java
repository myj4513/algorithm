package programmers.level2.destroycity;

import java.util.Scanner;

public class DestroyCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] answer = new String[n];

        for(int j=0;j<n;j++){
            int lastIdx=-1;
            char[] arr = scanner.nextLine().toCharArray();
            for(int i=0;i<arr.length;i++){
                if(arr[i]=='.') continue;
                if(arr[i]=='R'){
                    if(lastIdx==-1 || arr[lastIdx]=='L'){ //R...L 인경우
                        //아무것도 안함
                    }
                    else if(arr[lastIdx]=='R'){ //R...R인 경우
                        //모두 R로 바꿈
                        for(int k=lastIdx+1;k<i;k++) arr[k] = 'R';
                    }
                }
                else if(arr[i]=='L'){
                    if(lastIdx==-1 || arr[lastIdx]=='L'){ //L...L 인경우
                        //모두 L로 바꿈
                        for(int k=lastIdx+1;k<i;k++) arr[k] = 'L';
                    }
                    else if(arr[lastIdx]=='R'){ //L...R 인경우
                        //양쪽에서 하나씩 무너짐
                        int start = lastIdx+1;
                        int last = i-1;
                        while(start<last){
                            arr[start] = 'R';
                            arr[last] = 'L';
                            start++;
                            last--;
                        }
                    }
                }
                lastIdx = i;
            }
            if(arr[arr.length-1]=='.' && arr[lastIdx]=='R'){
                for(int k=lastIdx+1;k< arr.length;k++){
                    arr[k]='R';
                }
            }
            answer[j] = String.valueOf(arr);
        }
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
