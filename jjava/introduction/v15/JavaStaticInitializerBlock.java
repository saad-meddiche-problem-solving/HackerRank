package jjava.introduction.v15;

import java.util.Scanner;
import java.util.function.BiPredicate;

public class JavaStaticInitializerBlock {

    private static final Scanner scanner = new Scanner(System.in);

    private static Byte breadth;
    private static Byte height;

    static BiPredicate<Byte , Byte> isBothPositive = (a , b) -> a > 0 && b > 0;
    public static void main(String[] args) {

        scannData();

        if(isBothPositive.test(breadth , height)){
            System.out.println( breadth * height);
        }else {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void scannData(){
        breadth = scanner.nextByte();
        height = scanner.nextByte();
    }
}
