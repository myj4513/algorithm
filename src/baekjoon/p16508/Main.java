package baekjoon.p16508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] target;
    static int[] selected_books = new int[26];
    static List<Book> books = new ArrayList<>();
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String T = br.readLine();
        target = new int[26];
        for (int i = 0; i < T.length(); i++) {
            target[T.charAt(i) - 'A']++;
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            books.add(new Book(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        dfs(0,0);
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }

    private static void dfs(int index, int total) {
        if (index >= N) {
            if(check())
                min = min > total ? total : min;
            return;
        }

        for (int i = 0; i < books.get(index).name.length(); i++) {
            selected_books[books.get(index).name.charAt(i)-'A']++;
        }
        dfs(index + 1, total + books.get(index).price);
        for (int i = 0; i < books.get(index).name.length(); i++) {
            selected_books[books.get(index).name.charAt(i)-'A']--;
        }
        dfs(index+1, total);
    }

    private static boolean check() {
        for (int i = 0; i < 26; i++) {
            if(selected_books[i]<target[i])
                return false;
        }
        return true;
    }

    static class Book {
        int price;
        String name;

        public Book(int price, String name) {
            this.price = price;
            this.name = name;
        }
    }
}
