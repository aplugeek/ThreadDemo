package com.jerry.cn.SycholizedMethod;

/**
 * Date: 17/9/21 14:51
 *
 * @author jerry.R
 */

public class SycholizedMethod {
    public synchronized void test1() throws InterruptedException {
        System.out.println("test1....");
        Thread.sleep(10000);
        System.out.println("test1 release id lock...");
    }

    public synchronized void test2() throws InterruptedException {
        System.out.println("test2...");
        Thread.sleep(10000);
        System.out.println("test2 release id lock...");
    }
    public  void  test3() throws InterruptedException {
        synchronized (this){
            System.out.println("test3....");
            Thread.sleep(5000);
        }
    }
    public  void  test4() throws InterruptedException {
        synchronized (this){
            System.out.println("test4....");
            Thread.sleep(5000);
        }
    }


    public static void main(String[] args) {
        SycholizedMethod sycholizedMethod = new SycholizedMethod();
       /* new Thread(new Thread1(sycholizedMethod)).start();
        new Thread(new Thread2(sycholizedMethod)).start();*/
        new Thread(new Thread3(sycholizedMethod)).start();
        new Thread(new Thread4(sycholizedMethod)).start();
    }
}
