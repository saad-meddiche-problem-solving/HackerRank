package algorithms.implementation;

import java.io.*;

// https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=false
class DrawingBookResult {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int[][] book = {{0,1},{2,3},{4,5},{6,-1}};

    public static int pageCount(int n, int p) {

        int firstIndex = 0;
        int lastIndex  = n / 2;
        int pageIndex  = p / 2;

        int leftCount = pageIndex - firstIndex;
        int rightCount = lastIndex - pageIndex;

        return Math.min(leftCount, rightCount);

    }

}

public class DrawingBook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = DrawingBookResult.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
