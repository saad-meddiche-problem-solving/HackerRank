package algorithms.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class ElectronicsShopResult {

    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {

        Arrays.sort(keyboards);
        Arrays.sort(drives);

        if(keyboards[0] + drives[0] > b) return -1;

        if(keyboards[0] + drives[0] == b) return b;

        int[] cases = new int[keyboards.length * drives.length];

        for(int i = keyboards.length - 1; i >= 0; i--) {
            for(int j = drives.length - 1; j >= 0; j--) {
                int sum = keyboards[i] + drives[j];
                if(sum <= b) {
                    cases[i * drives.length + j] = sum;
                }
                else {
                    cases[i * drives.length + j] = -1;
                }
            }
        }

        Arrays.sort(cases);

        return cases[cases.length - 1];

    }

}

public class ElectronicsShop {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = ElectronicsShopResult.getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
