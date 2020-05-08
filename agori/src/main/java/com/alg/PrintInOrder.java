package com.alg;

import java.util.concurrent.Semaphore;

public class PrintInOrder {



    Semaphore semaphore2,semaphore3;
    public PrintInOrder() {

        semaphore2 = new Semaphore(0);
        semaphore3  = new Semaphore(0);

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        semaphore2.acquire();
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        semaphore3.acquire();
        printThird.run();
    }

}
