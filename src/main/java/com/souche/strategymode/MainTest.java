package com.souche.strategymode;

import com.souche.strategymode.behavior.Impl.Swimming;

/***
 *@author fanmiao
 *@date 2020/3/28 3:29 下午 
 */
public class MainTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.read();
        student.play();
        Teacher teacher = new Teacher();
        teacher.setPlay(new Swimming());
        student.read();
        teacher.play();

    }
}
