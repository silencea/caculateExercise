package com.fly;


/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/1
 * Time: 19:13
 */
public class Demo1 {
    static  int s =  0;
    static Integer index = 0;

    public static void main(String[] args) {
        final Object o = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (o) {

                while (index < 27){
                    System.out.println(Thread.currentThread().getName() +
                            Character.toUpperCase((char) (96 + index)));
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    index++;
                }
            }
            o.notify();
        }, "t1--> ");

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                while (index < 27){
                    System.out.println(Thread.currentThread().getName() +
                            Character.toUpperCase((char) (96 + index)));
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    index++;
                }
            }
            o.notify();
        }, "t2--> ");
        t1.start();
        t2.start();
    }

}
