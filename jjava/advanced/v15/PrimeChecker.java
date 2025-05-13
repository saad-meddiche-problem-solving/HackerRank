package jjava.advanced.v15;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

// https://www.hackerrank.com/challenges/prime-checker/problem?isFullScreen=true
class Prime {

    public void checkPrime(int... numbers) {

        StringJoiner stringJoiner = new StringJoiner(" ");

        for(int number : numbers) {
            if(isPrime(number)) stringJoiner.add(String.valueOf(number));
        }

        System.out.println(stringJoiner.toString());

    }

    private boolean isPrime(int num) {

        if(num == 0 || num == 1)
            return false;

        for(int i = 2 ; i <= Math.sqrt(num); i++)
            if(num % 2 == 0) return false;

        return true;
    }

}

public class PrimeChecker {

    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            int n1=scanner.nextInt();
            int n2=scanner.nextInt();
            int n3=scanner.nextInt();
            int n4=scanner.nextInt();
            int n5=scanner.nextInt();
            Prime ob=new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1,n2);
            ob.checkPrime(n1,n2,n3);
            ob.checkPrime(n1,n2,n3,n4,n5);
            Method[] methods=Prime.class.getDeclaredMethods();
            Set<String> set=new HashSet<>();
            boolean overload=false;
            for(int i=0;i<methods.length;i++)
            {
                if(set.contains(methods[i].getName()))
                {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());

            }
            if(overload)
            {
                throw new Exception("Overloading not allowed");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

}