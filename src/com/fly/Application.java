package com.fly;


import com.fly.other.PrintChar;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/1
 * Time: 19:13
 */
public class Application {


    public static void main(String[] args) {
        PrintChar.printChar2();
        AtomicInteger a = new AtomicInteger();
        a.incrementAndGet();
        //AtomicStampedReference
//        AtomicReference

    }

}
