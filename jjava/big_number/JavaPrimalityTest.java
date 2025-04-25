package jjava.big_number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.hackerrank.com/challenges/java-primality-test/problem
public class JavaPrimalityTest {

    private final static String PRIME = "prime";

    private final static String NOT_PRIME = "not prime";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();

        BigInteger number = new BigInteger(n);

        System.out.println(number.isProbablePrime(1) ? PRIME : NOT_PRIME);

        bufferedReader.close();
    }
}
