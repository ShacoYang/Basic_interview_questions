package com.exceptionsEx;

import java.util.InputMismatchException;
import java.util.Scanner;

// event which occurred during the execution of a program
// that disrupts the normal flow of the program's instructions
public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    //LBYL look before you leave
    private static int getIntLBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Enter an Integer");
        String input = s.next();
        for (int i = 0; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                isValid = false;
                break;
            }
        }
        if (isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }
    //EAFP easy to ask forgiveness than permission
    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter an Integer");
        try {
            return s.nextInt();
        }catch (InputMismatchException e) {
            return 0;
        }
    }
}
