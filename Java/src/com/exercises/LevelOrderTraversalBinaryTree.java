package com.exercises;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversalBinaryTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        Node root = null;
        Node node = new Node(0);

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            root = node.insertNodeRecursive(root, value);
        }

        node.traverseLevelOrder(root);

        scanner.close();
    }

    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void traverseLevelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);

            while (!nodes.isEmpty()) {

                Node node = nodes.remove();

                System.out.print(node.value + " ");

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        
        public void searchInOrder(Node node){
            if (node != null){
                System.out.println(node.value);
                searchInOrder(node.left);    
                searchInOrder(node.right);                 
                                
            }
        }

        public Node insertNodeRecursive(Node root, int value){
            if(root == null){
                return new Node(value);
            }
            if(value < root.value){
                root.left = insertNodeRecursive(root.left, value);
            }
            if(value > root.value){
                root.right = insertNodeRecursive(root.right, value);
            }
            return root;
        }

        public int getHeight(Node root){
            if(root == null){
                return -1;
            }

            int highLeft = getHeight(root);
            int highRight = getHeight(root);

            return Math.max(highLeft, highRight) + 1;

        }
    }
}
