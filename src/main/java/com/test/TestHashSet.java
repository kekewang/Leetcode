package com.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestHashSet {
    public HashSet hashSet = new HashSet();

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void execute(){
        executorService.execute(new HashSetThread(hashSet));
    }

    public void output(){
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            long threadId = (long) iterator.next();

            System.out.println(threadId);
        }
    }
    public static void main(String[] args){
        TestHashSet testHashSet = new TestHashSet();
        for (int i=0; i<100; i++)
            testHashSet.execute();
        testHashSet.output();
    }
}

class HashSetThread implements Runnable {

    private HashSet hashSet = null;

    public HashSetThread(HashSet hashSet) {
        this.hashSet = hashSet;
    }

    @Override
    public void run() {
        hashSet.add(Thread.currentThread().getId());

        System.out.println("add: " + Thread.currentThread().getId());
    }
}
