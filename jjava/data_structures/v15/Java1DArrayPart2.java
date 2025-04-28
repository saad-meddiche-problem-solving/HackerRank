package jjava.data_structures.v15;

import java.util.Scanner;

public class Java1DArrayPart2 {

    public static boolean canWin(int leap, int[] game ) {

        int n = game.length;

        int currentindex = 0;

        do {

            if(currentindex + leap >= n) return true;

            if(currentindex == n - 1) return true;

            if(currentindex + leap < n && game[currentindex + leap] == 0) {
                currentindex += leap;
                continue;
            }

            if(currentindex + 1 < n && game[currentindex + 1] == 0) {
                currentindex += 1;
                continue;
            }

            if(currentindex - 1 > 0 && game[currentindex - 1] == 0) {
                currentindex -= 1;
                continue;
            }

            break;

        } while (currentindex < n);

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

}
