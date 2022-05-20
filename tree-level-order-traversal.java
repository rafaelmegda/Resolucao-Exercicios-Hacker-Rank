import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	
    public static void levelOrder(Node root) {
      
      Queue<Node> queue = new LinkedList<>();
      queue.add(root);
      
      while(!queue.isEmpty()){
          Node nodeTemp = queue.poll();
          System.out.printf("%d ", nodeTemp.data);
          
        if(nodeTemp.left!=null)
            queue.add(nodeTemp.left);
        if(nodeTemp.right != null)
            queue.add(nodeTemp.right);
      }
      
    }
    
    /*public static void levelOrder(Node root) {
      
      int alt = height(root);
      
      for (int i = 0; i < alt; i++) {
          printNivel(root, i);
      }
      
    }    */
    
    public static void printNivel(Node root, Integer nivel){
        
        if(root == null){
            return;
        }
        if(nivel == 1){
            System.out.print(root.data + " ");
        }
        else if(nivel > 1){
            printNivel(root.left, nivel -1);
            printNivel(root.right, nivel - 1);
        }
    }
    
    public static int height(Node root) {
          if (root == null) {
              return -1;
          }

        int esq  = height(root.left);
        int dir = height(root.right);

        if(esq > dir){
            return esq + 1;
        }
        else{
            return dir + 1;
        }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}