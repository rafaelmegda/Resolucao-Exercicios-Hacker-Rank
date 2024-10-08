package com.exercises;
import java.io.*;
import java.util.*;

public class HeightOfABinaryTree {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int qtd = scanner.nextInt();
        Node root = null;
        Node node = new Node(0);        

        for (int i = 0; i < qtd; i++) {
            int value = scanner.nextInt();
            root = node.insertNodeRecursive(root, value);            
        }

        int height = node.getHeight(root);

        // Print output to STDOUT
        System.out.println(height);
        
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

            int highLeft = getHeight(root.left);
            int highRight = getHeight(root.right);

            return Math.max(highLeft, highRight) + 1;

        }
    } 
}
