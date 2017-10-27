package com.threadEx;

import static com.threadEx.ThreadColor.*;

//create a instance of a subclass rather than
//creating a thread instance
public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+ "main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("===why use start() not run()==");
        anotherThread.start(); // hello from == why use start() not run()==
        /*anotherThread.run(); //hello from main --> run on the same thread that called run method
        method 2
        Anonymous class*/
        new Thread() {
            public void run(){
                System.out.println(ANSI_GREEN+ "hello from the anonymous class");
            }
        }.start();

        /*create a instance of a Thread class
        pass the instance of myRunnable class to the thread constructor*/
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

//==============================================================================
        /*anonymous class impl runnable and pass the instance of it 2 the thread constructor*/
        Thread myRunnableThread1 = new Thread(new MyRunnable(){
            @Override
            public void run() {
//                super.run();
                System.out.println(ANSI_CYAN + "Hello from the anonymous class's impl of run()");
            }
        });
        myRunnableThread1.start();
//===============================================================================
        System.out.println("hello again from the main thread");

        /*
        Using a subclass of thread means we have to define the run method once
        but we CAN'T REUSE the same instance
        anotherThread.start(); --> exception
         */
    }
}
