package com.threadEx;

import static com.threadEx.ThreadColor.ANSI_BLUE;

/*
Using a subclass of thread means we have to define the run method once
but we CAN'T REUSE the same instance
 */
public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "hello from " + currentThread().getName());
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
        }
        System.out.println(ANSI_BLUE + "3s have passed and I'm awake");
    }
}
