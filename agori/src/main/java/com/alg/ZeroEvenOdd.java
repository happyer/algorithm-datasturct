package com.alg;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author : chengxu@corp.netease.com
 * @since : 2020/6/3
 */
public class ZeroEvenOdd {

    private int n;
    Semaphore zero, odd, even;
    boolean b = true;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        odd = new Semaphore(1);
        even = new Semaphore(1);
        try{
            odd.acquire();
            even.acquire();
        }catch(Exception e){;}
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i<n; i++){
            zero.acquire();
            printNumber.accept(0);
            System.out.println(0);

            if(b)
                odd.release();
            else
                even.release();
            b = !b;

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

}
