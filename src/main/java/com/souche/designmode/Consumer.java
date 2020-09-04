package com.souche.designmode;

import lombok.SneakyThrows;

/***
 *@author fanmiao
 *@date 2020/3/24 2:36 下午 
 */
public class Consumer implements Runnable {
    private Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000L);
            String s = warehouse.get();
            System.out.println(Thread.currentThread().getName() + "消费：" +s);
        }
    }
}
