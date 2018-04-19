package com.alg;

/**
 * Created by chauncy on 2018/4/19.
 */
public class MultiThtreadSwitch {


    public static class Number {
        int i = 0;
        boolean flag = true;  //是否该偶数线程执行
        boolean isSwitch = false;  //控制最后一位,是否需要交替
    }

    /**
     * 奇数线程
     */
    public static class OddNumber implements Runnable {


        private Number number;

        public OddNumber(Number number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.i <= 100) {
                //同步锁保证一致性
                synchronized (number) {
                    if (number.isSwitch) {
                        System.out.println(" 奇数：" + number.i);
                        return;
                    }
                    if (!number.flag && number.i != 99) {
                        System.out.println(" 奇数：" + number.i);
                        number.i++;
                        number.flag = true;
                        number.notify();
                    } else {
                        try {
                            number.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    /**
     * 偶数线程
     */
    public static class EvenNumber implements Runnable {
        private Number number;

        public EvenNumber(Number number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.i <= 100) {
                synchronized (number) {
                    if (number.flag && number.i <= 98) {

                        System.out.println(" 偶数：" + number.i);
                        number.i++;
                        number.flag = false;

                        number.notify();


                    } else {
                        if (number.i == 99) {
                            System.out.println(" 偶数：" + (number.i + 1));
                            number.flag = false;
                            number.isSwitch = true;
                            number.notify();
                        }

                        try {
                            number.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {


        Number num = new Number();

        OddNumber oddPriter = new OddNumber(num);
        EvenNumber evenPrinter = new EvenNumber(num);

        Thread oddthread = new Thread(oddPriter);
        Thread eventhread = new Thread(evenPrinter);

        oddthread.start();
        eventhread.start();


    }


}
