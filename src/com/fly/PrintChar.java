package com.fly;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/1
 * Time: 22:08
 */
public class PrintChar {

    static int index = 0;
    /**
     * 26个字母交替打印
     */
    public static void printChar() {

        final Object o = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (o) {

                while (index < 26) {
                    index++;
                    System.out.println(Thread.currentThread().getName() +
                            Character.toUpperCase((char) (96 + index)));
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }

        }, "t1--> ");

        Thread t2 = new Thread(() -> {
            synchronized (o) {

                while (index < 26) {
                    index++;
                    System.out.println(Thread.currentThread().getName() +
                            Character.toUpperCase((char) (96 + index)));
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }

        }, "t2--> ");
        t1.start();
        t2.start();
    }

    public static void printChar2(){
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();



        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                while (index < 26) {
                    index++;
                    System.out.println(Thread.currentThread().getName() +
                            Character.toUpperCase((char) (96 + index)));
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t1--> ");

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                while (index < 26) {
                    index++;
                    System.out.println(Thread.currentThread().getName() +
                            Character.toUpperCase((char) (96 + index)));

                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t2--> ");
        t1.start();
        t2.start();

    }
}
