package com.fly.baseCollection;

/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/5
 * Time: 9:25
 */
public class ThreadLocalDemo {

    /**
     * 新建对象的tl，是线程中的map的key
     * 当设置tl为null的时候，map中存储的对象还在，由于是弱引用，垃圾回收器会回收key，
     * 此时map中存储的就是{null，value}，会导致value的内存泄漏，所以在每次get/set时候ThreadLocal都会清除key为null的数据
     * 1，所以编程的时候建议使用完之后执行remove方法，加入不执行get/set方法的时候，value一直存在
     * 2，使用线程池的时候必须remove，不然的话就会造成数据混乱
     * @param args
     */
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        System.out.println(tl);
        tl.set("123");
        System.out.println("=========");
    }
}
