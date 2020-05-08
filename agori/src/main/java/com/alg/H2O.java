package com.alg;

import java.util.concurrent.Semaphore;

public class H2O {


    Semaphore h,o;

    public H2O() {

        h = new Semaphore(2);
        o = new Semaphore(0);
    }


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }
}
