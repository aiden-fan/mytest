package com.souche.factorymode.Impl;


import com.souche.factorymode.Bus;
import com.souche.factorymode.Car;
import com.souche.factorymode.Factory;

/***
 *@author fanmiao
 *@date 2020/4/8 4:52 下午 
 */
public class BwmFactory implements Factory {
    @Override
    public Bus getBus() {
        return new BwmBus();
    }

    @Override
    public Car getCar() {
        return new BwmCar();
    }
}
