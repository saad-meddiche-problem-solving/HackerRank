package jjava.advanced.v7;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/sha-256/problem?isFullScreen=true
public class JavaSHA256 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        MessageDigest sha2 = MessageDigest.getInstance("SHA-256");

        sha2.update(s.getBytes());

        byte[] digest = sha2.digest();

        for (byte i : digest)
            System.out.print(String.format("%02x", i));


        System.out.println();

    }

}
