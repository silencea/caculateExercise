package com.fly.baseCollection;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA
 * Created By lifeifei
 * Date: 2020/5/2
 * Time: 14:27
 */
public class BaseClassAnalysis {

    public static void main(String[] args) {
        //ArrayList
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(3,10);

        //转换成线程安全的list
        Collections.synchronizedList(arrayList);

        //LinkedList
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(3,4);

        //线程安全的list,读写分离
        CopyOnWriteArrayList aowa = new CopyOnWriteArrayList();
        aowa.add(2);
        aowa.get(1);
        aowa.iterator();

        CopyOnWriteArraySet coas = new CopyOnWriteArraySet();
        coas.add(1);

        //ReentrantLock
        ReentrantLock lock = new ReentrantLock();
        //读写锁
        ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

        Map map1 = new WeakHashMap<>();
        Map map2 = new HashMap<>();
        Map map3 = new ConcurrentHashMap(10);


    }
}
