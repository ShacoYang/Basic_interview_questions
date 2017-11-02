package com.lambdaEx;

public class LambdaEx {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous class method");
            }
        }).start();

        new Thread( ()-> System.out.println("lambda")).start();
    }
}

class CodeToRun implements Runnable  {
    @Override
    public void run() {
        System.out.println("printing from the runnable");
    }
}
