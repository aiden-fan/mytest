package com.souche.designmode;

import java.util.concurrent.*;

/***
 *@author fanmiao
 *@date 2020/3/24 2:54 下午 
 */
public class Test {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Consumer consumer = new Consumer(warehouse);
        Producer producer = new Producer(warehouse);
        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);
        consumerThread.start();
        producerThread.start();
    }

    private static void method() {
        Warehouse warehouse = new Warehouse();
        Consumer consumer = new Consumer(warehouse);
        Producer producer = new Producer(warehouse);
        ExecutorService executorService = new ThreadPoolExecutor(2,2,0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        executorService.submit(consumer);
        executorService.submit(producer);

    }
}
