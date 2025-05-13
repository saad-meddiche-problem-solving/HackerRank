package jjava.advanced.v7;

// https://www.hackerrank.com/challenges/java-singleton/problem?isFullScreen=true
public class JavaSingletonPattern { }

class Singleton {

    public String str;

    private Singleton() {}

    private final static Singleton INSTANCE = new Singleton();

    public static Singleton getSingleInstance() {
        return INSTANCE;
    }

}

