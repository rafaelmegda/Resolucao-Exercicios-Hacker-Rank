package com.exercises;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {

    /*
     * Complete the 'swapNodes' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY indexes
     *  2. INTEGER_ARRAY queries
     */

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        
        Node root = buildTree(indexes);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int k : queries) {
            swapSubTree(root, k, 1);
            List<Integer> inOrder = new ArrayList<>();
            inOrderTraversal(root, inOrder);
            result.add(inOrder);
        }
        
        return result;
    }
    public static Node buildTree(List<List<Integer>> indexes){
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        for (List<Integer> index : indexes) {
            Node current = queue.poll();
            if(index.get(0) != -1){
                current.left = new Node(index.get(0));
                queue.add(current.left);
            }
            if(index.get(1) != -1){
                current.right = new Node(index.get(1));
                queue.add(current.right);
            }
        }
        return root;
    }
    
    public static void inOrderTraversal(Node node, List<Integer> result){
        if (node == null) return;
        
        inOrderTraversal(node.left, result);
        result.add(node.value);
        inOrderTraversal(node.right, result);
    }
    
    public static void swapSubTree(Node node, int k, int h ){
        if (node == null) return;
        
        if(h % k == 0){
            Node temp= node.left;
            node.left = node.right;
            node.right = temp;
        }
        swapSubTree(node.left, k, h+1);
        swapSubTree(node.right, k, h+1);
    }

}

class Node{
    int value;
    Node left;
    Node right;

    Node(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class SwapNodesAlgo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> indexes = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                indexes.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<List<Integer>> result = Solution.swapNodes(indexes, queries);

        result.stream()
            .map(
                r -> r.stream()
                    .map(Object::toString)
                    .collect(joining(" "))
            )
            .map(r -> r + "\n")
            .collect(toList())
            .forEach(e -> {
                try {
                    bufferedWriter.write(e);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
