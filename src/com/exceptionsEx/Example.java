package com.exceptionsEx;

import java.util.Scanner;

// event which occurred during the execution of a program that disrupts the normal flow of
// the program's instructions
public class Example {
    public static void main(String[] args) {
        int result = divide();
        System.out.println(result);
    }
    private static int divide(){
        int x = getInt();
        int y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }
    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("enter an integer");
        return  s.nextInt();
    }
}
