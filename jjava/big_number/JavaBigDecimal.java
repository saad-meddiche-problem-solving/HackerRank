package jjava.big_number;

import java.math.BigDecimal;
import java.util.Scanner;

public class JavaBigDecimal {

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        //Write your code here

        // Populate bigDecimals
        BigDecimal[] bigDecimals = new BigDecimal[n];
        for(int i = 0 ; i < n ;i++) {
            bigDecimals[i] = new BigDecimal(s[i]);
        }

        // Sort
        boolean isSwapped;
        do {

            isSwapped = false;

            for(int i = 0 ; i < n - 1; i++) {

                if(bigDecimals[i].compareTo(bigDecimals[i + 1]) == -1) {

                    BigDecimal temp0 = bigDecimals[i];
                    bigDecimals[i] = bigDecimals[i + 1];
                    bigDecimals[i + 1] = temp0;

                    String temp1 = s[i];
                    s[i] = s[i + 1];
                    s[i + 1] = temp1;

                    isSwapped = true;
                }

            }

        } while (isSwapped);

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }


}
