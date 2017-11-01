package com.threadExCounter;

public class Main {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();

        CountDownThread t1 = new CountDownThread(countDown);
        t1.setName("Thread 1");
        CountDownThread t2 = new CountDownThread(countDown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

    }

}
class CountDown{
    //instance variable Thread variable
    /*
    heap --> apps memory that all threads share
    every thread has a thread stack (not share)
    t1 and t2 can both access the heap (local variables stored in the thread stack)
     */
    private int i;
    //=================
    public synchronized void doCountDown() {
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }
        /*thread can be suspended between steps
        examples:
        a thread could be suspended after the for has i-- but before the condition has been checked
        a thread could be suspended after executing all the code but before executing the print
         */
        /*
        NOT USE LOCAL VARIABLES to Synchronize full
        Thread stack only contains primitive values & obj references, functional refer
         */
//        synchronized (color){
//            for (i = 10; i > 0; i--) { //int i declare here
//                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
//            }
//        }
        for (i = 10; i > 0; i--) { //int i declare here
            System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
        }
    }
}

class CountDownThread extends Thread{
    private CountDown threadCountdown;

    public CountDownThread (CountDown countdown) {
        threadCountdown = countdown;
    }
    public void run() {
        threadCountdown.doCountDown();
    }
}