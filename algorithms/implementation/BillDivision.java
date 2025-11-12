package algorithms.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true
class BillDivisionResult {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */

    private static final String MESSAGE = "Bon Appetit";

    public static void bonAppetit(List<Integer> bill, int k, int b) {

        bill.remove(k);

        int annaBill = sum(bill) / 2;

        if(annaBill == b) {
            System.out.println(MESSAGE);
            return;
        }

        System.out.println(Math.abs(annaBill - b));

    }

    private static int sum(List<Integer> arrList) {

        int sum = 0;

        for(int number : arrList) {
            sum += number;
        }

        return sum;

    }

}

public class BillDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] billTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> bill = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int billItem = Integer.parseInt(billTemp[i]);
            bill.add(billItem);
        }

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        BillDivisionResult.bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}