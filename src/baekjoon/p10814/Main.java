package baekjoon.p10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Member[] arr = new Member[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Member(i, Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(arr, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age == o2.age)
                    return o1.idx - o2.idx;
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i].age).append(' ').append(arr[i].name).append('\n');
        }
        System.out.print(sb);
    }
}

class Member{
    int idx;
    int age;
    String name;

    public Member(int idx, int age, String name) {
        this.idx = idx;
        this.age = age;
        this.name = name;
    }
}
