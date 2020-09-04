package com.souche.designmode;

import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/***
 *@author fanmiao
 *@date 2020/3/24 2:29 下午 
 */
public class Warehouse {
    private List<String> list = Lists.newArrayList();
    private int maxNum = 10;

    public void add(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (list) {
                if (list.size() == 10) {
                    System.out.println("warehouse已满,list=" + list.size());
                    list.wait();
                }
                System.out.println("producer" + Thread.currentThread().getName() + "生产数据:" + str);
                list.add(str);
                list.notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String get() {
        String s = null;
        try {
            synchronized (list) {
                if (list.size() == 0) {
                    System.out.println("warehouse为空,list=" + list.size());
                    list.wait();
                    System.out.println("consumer中wait结束");
                }
                list.notifyAll();
                s =  list.remove(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
