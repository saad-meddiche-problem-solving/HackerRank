package jjava.advanced.v7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

// https://www.hackerrank.com/challenges/java-reflection-attributes/problem
public class JavaReflectionAttributes {

    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method method : methods){
            methodList.add(method.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

    class Student {
        public void getName() {
        }
        public void setId(String id) {

        }
        public void setEmail(String email) {

        }
        public void anothermethod() {  }
    }

}