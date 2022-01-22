package baekjoon.p12933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static char[] quack = new char[]{'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Queue<Duck> duckQueue = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'q') {
                if (duckQueue.isEmpty()) {
                    duckQueue.add(new Duck());
                } else {
                    int size = duckQueue.size();
                    boolean handled = false;
                    for (int j = 0; j < size; j++) {
                        Duck duck = duckQueue.poll();
                        if (duck.isUsing) {
                            duckQueue.add(duck);
                        } else {
                            duck.isUsing = true;
                            duck.curChar = 'q';
                            handled = true;
                            duckQueue.add(duck);
                            break;
                        }
                    }
                    if (handled) {
                        continue;
                    } else {
                        duckQueue.add(new Duck());
                    }
                }
            } else {
                int size = duckQueue.size();
                boolean handled = false;
                for (int j = 0; j < size; j++) {
                    Duck duck = duckQueue.poll();
                    if (duck.isUsing && ch == duck.getNext()) {
                        duck.curChar = duck.getNext();
                        if (duck.curChar == 'k') {
                            duck.isUsing = false;
                            duck.curChar = 'q';
                        }
                        handled = true;
                        duckQueue.add(duck);
                        break;
                    }
                    duckQueue.add(duck);
                }
                if (!handled) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        int size = duckQueue.size();
        for (int i = 0; i < size; i++) {
            Duck duck = duckQueue.poll();
            if (duck.isUsing) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(size);
    }

    static class Duck{
        char curChar;
        boolean isUsing;

        public Duck() {
            this.curChar = 'q';
            this.isUsing = true;
        }

        public boolean isNext(char nextChar) {
            if (nextChar == getNext()) {
                return true;
            }
            return false;
        }

        public char getNext() {
            for (int i = 0; i < 5; i++) {
                if (quack[i] == curChar) {
                    return quack[i + 1];
                }
            }
            return ' ';
        }
    }
}


