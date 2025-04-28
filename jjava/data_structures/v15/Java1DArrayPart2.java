package jjava.data_structures.v15;

import java.util.Scanner;

public class Java1DArrayPart2 {

    public static boolean canWin(int leap, int[] game) {
        return test(0,game,leap);
    }

    public static boolean test(int i, int[] game, int leap) {

        if(i < 0 || game[i] == 1) return false;
        if(i == game.length - 1 || i + leap >= game.length ) return true;

        game[i] = 1;
        return test(i+1,game,leap) || test(i+leap,game,leap) || test(i-1,game,leap);
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
