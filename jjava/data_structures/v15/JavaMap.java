package jjava.data_structures.v15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/phone-book/problem
public class JavaMap {

    private static Map<String,Integer> phoneBook = new HashMap<>();

    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s =in.nextLine();

            Integer phoneNumber = phoneBook.get(s);

            if(phoneNumber == null) {
                System.out.println("Not found");
            } else {
                System.out.println(String.format("%s=%d",s,phoneNumber));
            }

        }
    }

}
