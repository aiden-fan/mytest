package com.souche.factorymode.Impl;

import com.souche.factorymode.Car;

/***
 *@author fanmiao
 *@date 2020/4/8 4:50 下午 
 */
public class BwmCar implements Car {
    @Override
    public void produce() {
        System.out.println("car");
    }
}
