package jjava.object_oriented_programming.v7;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-interface/problem
public class JavaInterface {

    public static void main(String []args){
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

interface AdvancedArithmetic{
    int divisor_sum(int n);
}

//Write your code here
class MyCalculator implements AdvancedArithmetic {

    public int divisor_sum(int n) {

        int sum = n;

        for(int i = n/2 ; i > 0; i--) {

            int mod = n % i;

            if(mod == 0) sum+=i;

        }

        return sum;

    }

}
