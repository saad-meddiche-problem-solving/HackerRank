package jjava.advanced.v7;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-md5/problem?isFullScreen=true
public class JavaMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        MessageDigest md5 =  MessageDigest.getInstance("MD5");

        md5.update(s.getBytes());

        byte[] digest = md5.digest();

        String hash = new BigInteger(1, digest).toString(16);

        System.out.println(hash);

    }
}
