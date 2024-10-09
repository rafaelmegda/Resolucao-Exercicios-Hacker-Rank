package Java.src.com.exercises;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        
        Map<Integer, Integer> colorsCount = new HashMap<>();
        System.out.println(ar);
        
        for (int color : ar) {
            colorsCount.put(color, colorsCount.getOrDefault(color, 0) + 1);
        }
        System.out.println(colorsCount);
        
        int pairs = 0;
        for (int count : colorsCount.values()) {
            System.out.println(colorsCount.values());
            System.out.println(count);
            pairs += count / 2;
            System.out.println(pairs);
        }
        
        return pairs;

    }

}

public class SalesbyMatch {
    public static void main(String[] args) throws IOException {
        String filePath = "Java/src/com/exercises/inputFile.txt";
        
        // Create a BufferedReader to read from the file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        
        // Create a BufferedWriter to write to the output file
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Java/src/com/exercises/outputFile.txt"));


        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);
        System.err.println(result);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
