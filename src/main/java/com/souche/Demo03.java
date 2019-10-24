package com.souche;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.commons.compress.utils.Lists;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/***
 *@author fanmiao
 *@date 2019/10/15 2:34 下午 
 */
public class Demo03 {
    public static void main(String[] args) {
        method();
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
                strings.add(p.getName());
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
