package algorithms.implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true
class SalesByMatchResult {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {

        Collections.sort(ar);

        int pairCount = 0;

        for(int i = 0 ; i < n ; i++) {

            if(i + 1 >= n) break;

            Integer currenNumber = ar.get(i);

            Integer nextNumber = ar.get(i + 1);

            if(currenNumber == null || nextNumber == null) continue;

            if(currenNumber == nextNumber) {
                pairCount++;
                ar.set(i, null);
                ar.set(i+1, null);
            } else {
                ar.set(i, null);
            }

        }


        return pairCount;

    }

}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arTemp[i]);
            ar.add(arItem);
        }

        int result = SalesByMatchResult.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

