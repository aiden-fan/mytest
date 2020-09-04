package com.souche.designmode;

import lombok.SneakyThrows;

import java.util.UUID;

/***
 *@author fanmiao
 *@date 2020/3/24 2:15 下午 
 */
public class Producer implements Runnable {
    private Warehouse warehouse;

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }


    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000L);
            String s = UUID.randomUUID().toString();
            warehouse.add(s);
        }
    }
}
