package com.souche;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.souche.pojo.Person;
import org.apache.commons.compress.utils.Lists;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.*;

/***
 *@author fanmiao
 *@date 2019/10/15 2:34 下午 
 */

public class Demo03 {

    public static void main(String[] args) throws UnknownHostException {
//        BigDecimal bigDecimal = BigDecimal.valueOf(0);
//        BigDecimal bigDecimal2 = BigDecimal.valueOf(300L);
//        BigDecimal bigDecimal3 = BigDecimal.valueOf(300L);
//        ArrayList<BigDecimal> bigDecimals = Lists.newArrayList();
//        bigDecimals.add(bigDecimal);
//        bigDecimals.add(bigDecimal2);
//        bigDecimals.add(bigDecimal3);
//        BigDecimal reduce = bigDecimals.stream().reduce(BigDecimal.ZERO,BigDecimal::add);
//        System.out.println(reduce);
        method4();

    }


    public static void method4() {
        String a = "sdkfjhakjsdhfkjahsd";
        String b = a;


        a = "00j";
        System.out.println(b);

    }

    public static void method3() {
        final Person  person = new Person(1,"","test");
        person.setId(2);
        person.setPersonName("lisi");
        System.out.println(person);
    }

    public static Person method2() {
        return new Person();
    }




    public static void method() {
        Person person = new Person(1, "1", "");
        Person person1 = new Person(2, "2", "");
        Person person2 = new Person(3, "3", "");

        try {
            FileOutputStream outputStream = new FileOutputStream("b.xls");
            ExcelWriter writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLS);
            List<Person> people = Lists.newArrayList();
            people.add(person);
            people.add(person1);
            people.add(person2);
            List<List<String>> data = Lists.newArrayList();

            people.stream().forEach(p ->{
                List<String> strings = Lists.newArrayList();
                strings.add(p.getId() + "");
                strings.add(p.getPersonName());
                strings.add(p.getAddr());
                data.add(strings);
            });

            Sheet sheet = new Sheet(1,1,Person.class);
            sheet.setSheetName("test1");
            Sheet sheet1 = new Sheet(2, 1, Person.class);
            sheet1.setSheetName("test2");

            writer.write0(data,sheet);
            writer.write0(data, sheet1);
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
