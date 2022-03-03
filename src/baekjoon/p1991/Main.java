package baekjoon.p1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            char data = str.charAt(0);
            char left = str.charAt(2);
            char right = str.charAt(4);
            tree.addNode(data, left, right);
        }

        tree.preorder(tree.root);
        sb.append("\n");
        tree.inorder(tree.root);
        sb.append("\n");
        tree.postorder(tree.root);
        System.out.print(sb);
    }

    static class Tree{
        Node root;

        public void addNode(char data, char left, char right) {
            if (root == null) {
                root = new Node(data);
                if (left != '.')
                    root.left = new Node(left);
                if (right != '.')
                    root.right = new Node(right);
            } else {
                search(root, data, left, right);
            }
        }

        public void search(Node root, char data, char left, char right) {
            if (root == null) {
                return;
            } else if (root.data == data) {
                if (left != '.')
                    root.left = new Node(left);
                if (right != '.')
                    root.right = new Node(right);
            } else {
                search(root.left, data, left, right);
                search(root.right, data, left, right);
            }
        }

        public void preorder(Node root) {
            sb.append(root.data);
            if(root.left!=null) preorder(root.left);
            if(root.right!=null) preorder(root.right);
        }

        public void inorder(Node root) {
            if(root.left!=null) inorder(root.left);
            sb.append(root.data);
            if(root.right!=null) inorder(root.right);
        }

        public void postorder(Node root) {
            if(root.left!=null) postorder(root.left);
            if(root.right!=null) postorder(root.right);
            sb.append(root.data);
        }
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }
}
