package com.souche.strategymode;

import com.souche.strategymode.behavior.Impl.Swimming;
import com.souche.strategymode.behavior.Impl.ThreeKing;
import com.souche.strategymode.behavior.Play;
import com.souche.strategymode.behavior.Read;

/***
 *@author fanmiao
 *@date 2020/3/28 3:10 下午 
 */
public class Student extends People {

    public Student() {
        this.read = new ThreeKing();
    }

    public void setRead(Read read) {
        this.read = read;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
