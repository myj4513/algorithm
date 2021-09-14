package level2.combinationgame;


import java.util.*;

public class CombinationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            String[][] board = new String[9][3];
            for(int j=0;j<9;j++){
                board[j] = scanner.nextLine().split(" ");
            }
            Set<Set<Integer>> answerSet = getAnswerSet(board);
            System.out.println("answerSet = " + answerSet);
            Set<Set<Integer>> playerSet = new HashSet<>();
            int playerA = 0;
            int playerB = 0;
            boolean turn = true;  //true면 A차례, false이면 B차례
            while(true){
                String[] answer = scanner.nextLine().split(" ");
                if(answer[0].equals("H")) {//합을 외친 경우
                    Set<Integer> set = new HashSet<>();
                    set.add(Integer.parseInt(answer[1])-1);
                    set.add(Integer.parseInt(answer[2])-1);
                    set.add(Integer.parseInt(answer[3])-1);
                    if(answerSet.contains(set) && !playerSet.contains(set)){  //정답일 경우
                        if(turn) playerA++;
                        else playerB++;
                        playerSet.add(set);
                    }
                    else{  //오답일 경우
                        if(turn) playerA--;
                        else playerB--;
                        if(playerA<0) playerA=0;
                        if(playerB<0) playerB=0;
                    }
                }
                else if(answer[0].equals("G")){ //결을 외친 경우
                    if(answerSet.size()==playerSet.size()){ //정답일 경우 -> 게임이 종료됨
                        if(turn) playerA+=3;
                        else playerB++;
                        System.out.println(playerA+" "+playerB);
                        break;
                    }
                    else{ //오답일경우
                        if(turn) playerA--;
                        else playerB--;
                        if(playerA<0) playerA=0;
                        if(playerB<0) playerB=0;
                    }
                }
                turn = !turn;
                System.out.println("playerSet = " + playerSet);
            }

        }
    }

    public static Set<Set<Integer>> getAnswerSet(String[][] board){
        Set<Set<Integer>> answerSet = new HashSet<>();
        for(int i=0;i<9;i++)
            for(int j=i+1;j<9;j++)
                for(int k=j+1;k<9;k++){
                    if(isValid(i,j,k, board)){
                        Set<Integer> set = new HashSet<>();
                        set.add(i); set.add(j); set.add(k);
                        answerSet.add(set);
                    }
                }
        return answerSet;
    }

    public static boolean isValid(int a, int b, int c, String[][] board){
        for(int i=0;i<3;i++){
            if(board[a][i].equals(board[b][i]) && board[b][i].equals(board[c][i]) && board[c][i].equals(board[a][i])){

            }
            else if(!board[a][i].equals(board[b][i]) && !board[b][i].equals(board[c][i]) && !board[c][i].equals(board[a][i])){

            }
            else return false;
        }
        return true;
    }
}
