package com.staticInitEx;

/*
The static block only gets called once,
when the class itself is initialized,
no matter how many objects of that type you create.

static section will be executed at class load time,
before any instances of the class are constructed
 */
public class StaticInitExample {
    static {
        System.out.println("static initialization block");
    }

    {
        System.out.println("Non-static block");
    }

    public static void main(String[] args) {
        StaticInitExample s1 = new StaticInitExample();
        StaticInitExample s2 = new StaticInitExample();
    }
}
