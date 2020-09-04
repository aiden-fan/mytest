package com.souche.excel;

import com.souche.enums.ImportEnums;
import lombok.SneakyThrows;

/***
 *@author fanmiao
 *@date 2020/3/25 3:06 下午 
 */
public class Test {

    public static void main(String[] args) {
//        method();
        try {
            System.out.println("test");
            return;
        } catch (Exception e) {

        } finally {
            System.out.println("finally");
        }

    }

    @SneakyThrows
    public static void method() {
//        Person person = new Person(1, "1", "");
//        Person person1 = new Person(2, "2", "");
//        Person person2 = new Person(3, "3", "");
//        List<Person> people = Lists.newArrayList();
//        people.add(person);
//        people.add(person1);
//        people.add(person2);
//        File temp = new File("temp.xlsx");
//        FileOutputStream os = new FileOutputStream(temp);
//        ExcelWriter writer = new ExcelWriter(os, ExcelTypeEnum.XLSX, true);
//        Sheet sheet = new Sheet(1, 0, Person.class);
//        sheet.setSheetName("ldk");
//        writer.write(people, sheet);
//        writer.finish();

        Class model = ImportEnums.OFFLINE.getModel();
        Class model1 = ImportEnums.OFFLINE.getModel();

    }


}
