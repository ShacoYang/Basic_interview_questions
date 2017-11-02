# Basic_interview_questions
This repo shows examples for some frequentlly asked Java question 

* [static](https://github.com/ShacoYang/Basic_interview_questions/tree/master/out/production/MiniExamples/com/staticInitEx)  
- [exception](https://github.com/ShacoYang/Basic_interview_questions/tree/master/out/production/MiniExamples/com/exceptionsEx)

* cogsPulleyEx:     
    * Array - Fastest but fixed size  
    * Linked List - Constant for removing the first element  
    * Doubly Linked list - Constant for removal at end
    * Circular Linked List - loops indefinitely  
* lambda  
    *  ```java
        new Thread(new CodeToRun()).start();
        class CodeToRun implements Runnable  {
            @Override
            public void run() {
                System.out.println("printing from the runnable");
            }
        }
    *  ```java  
        new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("anonymous class method");
                }
            }).start();         
    * ```java
        new Thread( ()-> System.out.println("lambda")).start();
