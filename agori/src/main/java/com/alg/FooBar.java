package com.alg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;

    private volatile int total = 0;
    private Semaphore semaphore;
    private Semaphore fooSemaphore;

    public FooBar(int n) {
        this.n = n;
        this.total = n;
        semaphore = new Semaphore(0);
        fooSemaphore = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            fooSemaphore.acquire();
            if (i < total){
                printFoo.run();
                semaphore.release();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphore.acquire();
            if (i < total){
                printBar.run();
            }
            fooSemaphore.release();
        }
    }



}
