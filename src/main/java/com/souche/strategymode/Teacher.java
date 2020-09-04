package com.souche.strategymode;

import com.souche.strategymode.behavior.Impl.Run;
import com.souche.strategymode.behavior.Impl.WestVisit;
import com.souche.strategymode.behavior.Play;
import com.souche.strategymode.behavior.Read;

/***
 *@author fanmiao
 *@date 2020/3/28 3:28 下午 
 */
public class Teacher extends People{

    public Teacher() {
        this.play = new Run();
        this.read = new WestVisit();
    }

    public void setRead(Read read) {
        this.read = read;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
