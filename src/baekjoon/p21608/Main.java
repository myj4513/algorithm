package baekjoon.p21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] classroom;
    static Map<Integer, List<Integer>> students;
    static int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        classroom = new int[N][N];

        students = new LinkedHashMap<>();
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            students.put(index, list);
        }

        for (Integer studentNum : students.keySet()) {

            Pos finalPos = null;

            int max = -1;
            List<Pos> list = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(classroom[r][c]==0){
                        int cntLike = cntLike(studentNum, r, c);
                        if(cntLike > max){
                            max = cntLike;
                            list.clear();
                            list.add(new Pos(r, c));
                        } else if (cntLike == max) {
                            list.add(new Pos(r, c));
                        }
                    }
                }
            }
            //System.out.println("친구 수 최대 자리들 : " + list);

            int maxSeat = -1;
            List<Pos> maxSeatList = new ArrayList<>();
            if (list.size() > 1) {
                for(Pos pos : list){
                    int cntEmpty = cntEmpty(pos);
                    if (cntEmpty > maxSeat) {
                        maxSeat = cntEmpty;
                        maxSeatList.clear();
                        maxSeatList.add(pos);
                    } else if (cntEmpty == maxSeat) {
                        maxSeatList.add(pos);
                    }
                }
            }
            else
            {
                finalPos = list.get(0);
                classroom[finalPos.getR()][finalPos.getC()] = studentNum;
                continue;
            }

            //System.out.println("max Seat List : " + maxSeatList);

            if (maxSeatList.size() > 1) {
                finalPos = findMinPos(maxSeatList);
            }
            else
            {
                finalPos = maxSeatList.get(0);
            }

            //System.out.println("최종 위치 " + finalPos);
            classroom[finalPos.getR()][finalPos.getC()] = studentNum;
        }

        int sum = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int cntLikes = cntLike(classroom[r][c], r, c);
                int point = 0;
                switch (cntLikes) {
                    case 1:
                        point = 1;
                        break;
                    case 2:
                        point = 10;
                        break;
                    case 3:
                        point = 100;
                        break;
                    case 4:
                        point = 1000;
                        break;
                }
                sum += point;
            }
        }
        System.out.println(sum);
    }

    public static Pos findMinPos(List<Pos> posList){
        int minR = 21;
        int minC = 21;
        for (Pos pos : posList) {
            int r = pos.getR();
            int c = pos.getC();
            if(r<minR){
                minR = r;
                minC = c;
            } else if (r == minR) {
                if (c < minC) {
                    minC = c;
                }
            }
        }

        return new Pos(minR, minC);
    }

    public static int cntEmpty(Pos pos){
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int rPos = pos.getR() + move[i][0];
            int cPos = pos.getC() + move[i][1];
            if (0 <= rPos && rPos < N && 0 <= cPos && cPos < N) {
                if(classroom[rPos][cPos] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public static int cntLike(int idx, int r, int c){

        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int rPos = r + move[i][0];
            int cPos = c + move[i][1];
            if (0 <= rPos && rPos < N && 0 <= cPos && cPos < N) {
                if(students.get(idx).contains(classroom[rPos][cPos])){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

class Pos{

    private int r;
    private int c;

    public Pos(int r, int c){
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC(){
        return c;
    }

    public String toString(){
        return r + "," + c;
    }
}