package jjava.introduction.v15;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-output-formatting/problem
public class JavaOutputFormatting {

    private static final int STRING_COLUMN_LENGTH = 15;

    private static final int INT_COLUMN_LENGTH = 3;

    private static final String TEMPLATE = "%1$-" + STRING_COLUMN_LENGTH + "s%2$0" + INT_COLUMN_LENGTH + "d";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");

        for(int i=0;i<3;i++){
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.println(String.format(TEMPLATE,s1,x));
        }

        System.out.println("================================");

    }

}
