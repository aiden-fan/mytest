package com.souche.factorymode.Impl;

import com.souche.factorymode.Bus;

/***
 *@author fanmiao
 *@date 2020/4/8 4:48 下午 
 */
public class BwmBus implements Bus {
    @Override
    public void produce() {
        System.out.println("bus");
    }
}
