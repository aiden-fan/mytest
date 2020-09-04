package com.souche.test.impl;

import com.souche.test.Test01;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/***
 *@author fanmiao
 *@date 2019/12/8 20:52 
 */
public class Test02  {
    public static void main(String[] args)throws Exception {
        String s = "(994,'[{\"accountNo\":\"95200155300001827\",\"requestNo\":\"\",\"serialNumber\":\"899012500295-D-20190829144747，899016720592-D-20190829144905\"}]'),\n";
        String[] split = s.split("，");

        int i1 = split[0].indexOf("{");
        String tou = split[0].substring(0, i1);

        int i = split[0].lastIndexOf(":");
//        split[0] = split[0].substring(0, i);
        String zhong = split[0].substring(i1,i);
        String qici = split[0].substring(i);
        System.out.println(split[0]);

//        System.out.println(tou);
        System.out.println(zhong);
        System.out.println(qici);



    }
}
