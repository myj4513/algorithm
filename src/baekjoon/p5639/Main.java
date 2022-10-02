package baekjoon.p5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        while (true) {
            String str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            list.add(Integer.parseInt(str));
        }
        Node root = new Node(list.get(0), null, null);
        for (int i = 1; i < list.size(); i++) {
            root.insertNode(list.get(i));
        }

        root.printNode();
    }

    static class Node {
        int val;
        Node left;
        Node right;

        void printNode() {
            if (this.left != null) {
                left.printNode();
            }
            if (this.right != null) {
                right.printNode();
            }
            System.out.println(val);
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        
        void insertNode(int val) {
            while (true) {
                if (val < this.val) {
                    if (this.left == null) {
                        this.left = new Node(val, null, null);
                    } else {
                        left.insertNode(val);
                    }
                    return;
                } else {
                    if (this.right == null) {
                        this.right = new Node(val, null, null);
                    } else {
                        right.insertNode(val);
                    }
                    return;
                }
            }
        }
    }
}



