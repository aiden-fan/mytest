package com.souche.strategymode;

import com.souche.strategymode.behavior.Impl.Swimming;
import com.souche.strategymode.behavior.Impl.WestVisit;
import com.souche.strategymode.behavior.Play;
import com.souche.strategymode.behavior.Read;

/***
 *@author fanmiao
 *@date 2020/3/28 3:07 下午 
 */
public abstract class People {

    protected Play play = new Swimming();
    protected Read read = new WestVisit();


    public void eat() {
        System.out.println("吃饭");
    }

    public void drink() {
        System.out.println("喝水");
    }

    public void play() {
        play.palying();
    }

    public void read() {
        read.read();
    }
}
