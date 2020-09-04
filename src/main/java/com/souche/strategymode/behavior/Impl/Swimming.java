package com.souche.strategymode.behavior.Impl;

import com.souche.strategymode.behavior.Play;

/***
 *@author fanmiao
 *@date 2020/3/28 3:19 下午 
 */
public class Swimming implements Play {
    @Override
    public void palying() {
        System.out.println("游泳");
    }
}
