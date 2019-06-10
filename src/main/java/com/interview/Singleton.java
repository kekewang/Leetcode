package com.interview;

public class Singleton {
    private static Singleton singleton = null;

    private Singleton() {

    }

    public synchronized Singleton instance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }
}

class Singleton1 {
    private volatile Singleton1 singleton = null;

    private Singleton1() {

    }

    public Singleton1 instance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }

        return singleton;
    }
}
